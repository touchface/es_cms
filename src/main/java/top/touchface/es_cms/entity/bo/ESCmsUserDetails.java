package top.touchface.es_cms.entity.bo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.touchface.es_cms.entity.po.Role;
import top.touchface.es_cms.entity.po.User;
import top.touchface.es_cms.entity.po.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户详情，用于Spring-Security
 * </p>
 *
 * @author touchface
 * @since 2019-11-12
 */
@Data
public class ESCmsUserDetails extends User implements UserDetails {

    private List<GrantedAuthority> authorities;

    /**
     * 构造函数，初始化赋予的权限数组
     */
    public ESCmsUserDetails(){
        authorities=new ArrayList<>();
    }

    @Override
    public User setUserRoles(List<UserRole> userRoles) {
        // 设置用户角色
        super.setUserRoles(userRoles);
        // 设置校验的权限集合
        for(UserRole userRole:userRoles){
            this.authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole().getRoleId()));
        }
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getUserPass();
    }

    @Override
    public String getUsername() {
        return super.getUserAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return super.getUserStatus()!=-1?true:false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
