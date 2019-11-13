package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.touchface.es_cms.common.enums.ApiMethodEnum;

/**
 * <p>
 * 用户实体，用户保存用户基本信息
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPass;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户网址
     */
    private String userUrl;

    /**
     * 注册时间
     */
    private LocalDateTime userRegistered;

    /**
     * 激活码
     */
    private String userActiveKey;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 当前用户所拥有的用户角色
     */
    private List<UserRole> userRoles;

    /**
     * 校验用户是否拥有指定名称角色,包含指定角色名称返回true,否则返回false
     * @param roleName 角色名称
     * @return 校验结果
     */
    public boolean checkRoleName(String roleName){
        // 获取当前时间
        LocalDateTime now=LocalDateTime.now();
        for (UserRole userRole:userRoles){
            // 判断角色到期时间是否为空，不为空则进行角色日期过期校验,如果过期则不进行下次校验
            if(userRole.getRoleDueTime()!=null&&userRole.getRoleDueTime().isBefore(now)){
                continue;
            }
            if(userRole.getRole().getRoleName().equals(roleName)){
                return true;
            }
        }
        return false;
    }


    public boolean checkApiRight(String uri, ApiMethodEnum method){
        // 获取当前时间
        LocalDateTime now=LocalDateTime.now();
        for (UserRole userRole:userRoles){
            // 判断角色到期时间是否为空，不为空则进行角色日期过期校验,如果过期则不进行下次校验
            if(userRole.getRoleDueTime()!=null&&userRole.getRoleDueTime().isBefore(now)){
                continue;
            }
            if(userRole.getRole().checkApiRight(uri,method)){
                return true;
            }
        }
        return false;
    }
}
