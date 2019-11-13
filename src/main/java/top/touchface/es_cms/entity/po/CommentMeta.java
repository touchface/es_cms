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
 * 评论拓展信息

 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_comment_meta")
public class CommentMeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cmeta_id", type = IdType.AUTO)
    private Long cmetaId;

    /**
     * 主键
     */
    private Long cmtId;

    /**
     * 键名
     */
    private String metaKey;

    /**
     * 键值
     */
    private String metaValue;

}
