package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.touchface.es_cms.common.enums.ApiMethodEnum;

/**
 * <p>
 * 用户角色信息
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDescription;

    /**
     * 角色标志：0普通角色，1开发者
     */
    private Integer roleFlag;

    /**
     * 角色数据接口权限
     */
    private List<ApiRight> apiRights;

    /**
     * 校验当前角色是否拥有指定路径的接口权限
     * @param uri 请求路径
     * @param method 请求方式
     * @return 校验结果
     */
    public boolean checkApiRight(String uri, ApiMethodEnum method){
        boolean flag=false;
        for(ApiRight apiRight:apiRights){
            // 判断请求路径是否匹配
            if(apiRight.getApi().getApiUrl().startsWith(uri)){
                switch (method){
                    case GET:
                        flag=apiRight.getApiRead();
                        break;
                    case POST:
                        flag=apiRight.getApiWrite();
                        break;
                    case PUT:
                        flag=apiRight.getApiUpdate();
                        break;
                    case DELETE:
                        flag=apiRight.getApiDelete();
                        break;
                }
            }
            if(flag){
                break;
            }
        }
        return flag;
    }
}
