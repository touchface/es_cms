package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 数据接口信息
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_api")
public class Api implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "api_id", type = IdType.AUTO)
    private Long apiId;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口路径
     */
    private String apiUrl;

    /**
     * 接口状态
     */
    private Integer apiStatus;

    /**
     * 读取权限
     */
    private Boolean apiRead;

    /**
     * 写入权限
     */
    private Boolean apiWrite;

    /**
     * 更新权限
     */
    private Boolean apiUpdate;

    /**
     * 删除权限
     */
    private Boolean apiDelete;
}
