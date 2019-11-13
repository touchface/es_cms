package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.touchface.es_cms.common.enums.ApiMethodEnum;

/**
 * <p>
 * 接口权限
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_api_right")
public class ApiRight implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 接口主键
     */
    private Long apiId;

    /**
     * 数据接口写入权限
     */
    private Boolean apiWrite;

    /**
     * 数据接口更新权限
     */
    private Boolean apiUpdate;

    /**
     * 数据接口读取权限
     */
    private Boolean apiRead;

    /**
     * 数据接口删除访问权限
     */
    private Boolean apiDelete;

    /**
     * 数据接口详情
     */
    private Api api;
}
