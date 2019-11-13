package top.touchface.es_cms.web.filter;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.plugin.liveconnect.SecurityContextHelper;
import top.touchface.es_cms.common.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * JWT令牌认证拦截器
 * </p>
 *
 * @author touchface
 * @since 2019-11-13
 */
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    /**
     * 注入用户安全认证服务
     */
    private final UserDetailsService userDetailsService;

    /**
     * JWT工具
     */
    private final JwtUtil jwtUtil;

    @Autowired
    public JwtAuthorizationTokenFilter(UserDetailsService userDetailsService, JwtUtil jwtUtil){
        this.userDetailsService=userDetailsService;
        this.jwtUtil=jwtUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 获取令牌请求头
        final String header=httpServletRequest.getHeader(jwtUtil.getHeader());
        String username=null;// 用户名
        String token=null;// 认证令牌

        // 获取认证信息
        if(header!=null&&header.startsWith("JWT ")){
            token = header.substring(header.indexOf("JWT "),header.length());
            // 解析TOKEN中的内容获取用户名
            try {
                username=jwtUtil.getUsernameFromToken(token);
            }catch (ExpiredJwtException e) {
                // 如果令牌过期，则返回令牌过期信息
                // 请求认证失败，令牌已过期。
                httpServletResponse.setStatus(401);
                httpServletResponse.setHeader("error","请求认证失败，令牌已过期。");
            }
        }
        // 获取当前用户的请求认证信息详情
        if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
            // 如果用户账号不为空且认证信息为空，则获取认证信息详情
            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            // 将用户凭证存入SecurityContextHolder中
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
