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
 * 内容管理系统资源信息
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源
     */
    @TableId(value = "res_id", type = IdType.AUTO)
    private Long resId;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * MIME类型
     */
    private String resMimeType;

    /**
     * 资源地址
     */
    private String resUrl;

    /**
     * 相对路径
     */
    private String resPath;

    /**
     * 创建时间
     */
    private LocalDateTime resTime;

}
