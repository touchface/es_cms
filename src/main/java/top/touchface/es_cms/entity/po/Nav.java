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
 * 导航栏
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_nav")
public class Nav implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "nav_id", type = IdType.AUTO)
    private Long navId;

    /**
     * 主键
     */
    private Long navParent;

    /**
     * 导航名称
     */
    private String navName;

    /**
     * 导航链接
     */
    private String navUrl;

    /**
     * 导航状态
     */
    private Integer navStatus;

}
