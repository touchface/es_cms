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
 * 用于保存用户的拓展信息，键值对形式
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_post_meta")
public class PostMeta implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "pmeta_id", type = IdType.AUTO)
    private Long pmetaId;

    /**
     * 主码
     */
    private Long postId;

    /**
     * 键名
     */
    private String metaKey;

    /**
     * 键值
     */
    private String metaValue;

}
