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
 * 用于存放发布内容信息
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主码
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Long postId;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 帖子标题
     */
    private String postTitle;

    /**
     * 帖子摘要
     */
    private String postExcerpt;

    /**
     * 帖子状态
     */
    private Integer postStatus;

    /**
     * 审核状态
     */
    private Integer postAudit;

    /**
     * 帖子正文
     */
    private String postContent;

    /**
     * 帖子密码
     */
    private String postPassword;

    /**
     * 缩略名
     */
    private String postName;

    /**
     * 排序系数
     */
    private Integer postOrder;

    /**
     * 帖子类型
     */
    private Integer postType;

    /**
     * 发布时间
     */
    private LocalDateTime postTime;

    /**
     * 修改时间
     */
    private LocalDateTime postModified;

    /**
     * 评论条数
     */
    private Long cmtCount;

    /**
     * 评论权限
     */
    private Integer cmtRight;

    /**
     * MIME类型
     */
    private String postMimeType;

}
