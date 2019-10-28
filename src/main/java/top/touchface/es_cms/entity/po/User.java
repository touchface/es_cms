package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 用户实体，用户保存用户基本信息
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
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

}
