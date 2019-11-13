package top.touchface.es_cms.common.util;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWT工具类
 * 
 * @author Jason
 *
 */
@Data
@Component
public class JwtUtil implements Serializable {
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.header}")
	private String header;
	@Value("${jwt.expiration}")
	private Long expiration;

	private Clock clock= DefaultClock.INSTANCE;

    /**
     * 使用Base64加密Key
     *
     * @return 加密后的的Key
     */
	private SecretKey generalKey(){
		
		byte[] encodeKey=Base64.getDecoder().decode(secret);
		SecretKey key=new SecretKeySpec(encodeKey, 0,encodeKey.length,"AES");
		return key;
	}
	/**
	 * 创建JWT令牌
	 * 
	 * @param claims 载荷
	 * @param expiresMillis 过期时间
	 * @return 加密生成令牌
	 */
	public String createToken(Map<String,Object> claims, long expiresMillis){
		
		JwtBuilder builder=Jwts.builder();
		//设置JWT头
		builder.setHeaderParam("typ", "JWT");
		builder.setHeaderParam("alg", "HS256");
		//设置JWT的有效载荷
		claims.forEach(builder::claim);
		//设置签发时间
		long nowMillis=clock.now().getTime();
		builder.setIssuedAt(new Date(nowMillis));
		//设置过期时间
		if(expiresMillis>0){
			 long expMillis = nowMillis + expiresMillis;
			 builder.setExpiration(new Date(expMillis));
		}
		//设置加密算法
		builder.signWith(SignatureAlgorithm.HS256,generalKey());
		return builder.compact();
	}

	/**
	 * 创建JWT令牌,如果application.yml配置文件中配置了过期时间，则将令牌过期时间设置为对应的过期时间
	 * 否则不过期。
	 * @param claims  载体
	 * @return 生成的令牌
	 */
	public String createToken(Map<String,Object> claims){
		return createToken(claims,expiration==null?0:expiration);
	}

	/**
	 * 解析JWT,获取TOKEN内容
	 * @param token 令牌
	 * @return 解析结果
	 */
	public Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
	}

	/**
	 * 解析JWT获取用户登录账号
	 * @param token 令牌
	 * @return 解析结果
	 */
	public String getUsernameFromToken(String token) {
		return this.parseToken(token).get("userAccount",String.class);
	}

	/**
	 * 判断令牌是否过期
	 * @param token 令牌
	 * @return 是否过期 true:过期，false:未过期
	 */
	public Boolean isTokenExpired(String token){
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(clock.now());
	}

	/**
	 * 获取TOKEN中的指定数据
	 * @param token 令牌
	 * @param claimsResolver 处理器
	 * @param <T> 数据类型
	 * @return 返回值
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = this.parseToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * 获取令牌过期时间
	 * @param token 令牌
	 * @return 过期时间
	 */
	public Date getExpirationDateFromToken(String token) {
		return this.getClaimFromToken(token, Claims::getExpiration);
	}
}
