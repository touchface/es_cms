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
 * 分类法信息表
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_term_taxonomy")
public class TermTaxonomy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "tax_id", type = IdType.AUTO)
    private Long taxId;

    /**
     * 主键
     */
    private Long cmsTaxId;

    /**
     * 主键
     */
    private Long termId;

    /**
     * 分类名称
     */
    private String taxName;

    /**
     * 分类描述
     */
    private String taxDescription;

    /**
     * 资源数量
     */
    private Long taxCount;

    /**
     * 创建者ID
     */
    private Long taxCreater;

}
