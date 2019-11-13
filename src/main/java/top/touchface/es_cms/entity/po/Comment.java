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
 * 保存用户评论信息
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "cmt_id", type = IdType.AUTO)
    private Long cmtId;

    /**
     * 主键
     */
    private Long cmtParent;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 主码
     */
    private Long postId;

    /**
     * 评论者
     */
    private String cmtAuthor;

    /**
     * 评论者邮箱
     */
    private String cmtAuthorEmail;

    /**
     * 评论者网址
     */
    private String cmtAuthorUrl;

    /**
     * 评论者IP
     */
    private String cmtAuthorIp;

    /**
     * 评论时间
     */
    private LocalDateTime cmtTime;

    /**
     * 评论正文
     */
    private String cmtContent;

    /**
     * 用户标志
     */
    private Integer cmtAgent;

    /**
     * 评论类型
     */
    private Integer cmtType;

    /**
     * 评论状态
     */
    private Integer cmtStatus;

    /**
     * 审核状态
     */
    private Integer cmtAudit;

}
