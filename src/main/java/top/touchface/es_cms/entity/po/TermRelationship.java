package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_term_relationship")
public class TermRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long taxId;

    /**
     * 主码
     */
    private Long postId;

}
