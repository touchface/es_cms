package top.touchface.es_cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.touchface.es_cms.entity.bo.ESCmsUserDetails;
import top.touchface.es_cms.entity.po.User;
import top.touchface.es_cms.mapper.UserMapper;

/**
 * <p>
 * JWT用户校验服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-11-13
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户名获取用户信息
     * @param username 用户名
     * @return 用户详情
     * @throws UsernameNotFoundException 用户未找到异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_account",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        // 创建用户校验详情对象
        ESCmsUserDetails userDetails=new ESCmsUserDetails();
        // 将数据库中对应的用户信息拷贝到校验对象当中
        BeanUtils.copyProperties(user,userDetails);
        return userDetails;
    }
}
