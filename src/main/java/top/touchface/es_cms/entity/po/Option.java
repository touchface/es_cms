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
 * 内容管理系统系统设置信息
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_option")
public class Option implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "opt_id", type = IdType.AUTO)
    private Long optId;

    /**
     * 设置名称
     */
    private String optName;

    /**
     * 设置代码
     */
    private String optCode;

    /**
     * 设置值
     */
    private String optValue;

    /**
     * 是否自动载入
     */
    private Integer optAutoload;

}
