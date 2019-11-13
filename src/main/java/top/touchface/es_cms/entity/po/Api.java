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
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_api")
public class Api implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口主键
     */
    @TableId(value = "api_id", type = IdType.AUTO)
    private Long apiId;

    /**
     * 接口主键
     */
    private Long apiParent;

    /**
     * 数据接口名称
     */
    private String apiName;

    /**
     * 数据接口请求路径
     */
    private String apiUrl;

    /**
     * 接口状态:-1:禁用、0:关闭校验、1:开启校验
     */
    private Integer apiStatus;

}
