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
 * 友情链接信息
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_link")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 键名
     */
    @TableId(value = "link_id", type = IdType.AUTO)
    private Long linkId;

    /**
     * 主键
     */
    private Long userId;

    /**
     * 链接标题
     */
    private String linkTitle;

    /**
     * 链接URL
     */
    private String linkUrl;

    /**
     * 链接打开方式
     */
    private String linkTarget;

    /**
     * 链接状态
     */
    private Integer linkStatus;

    /**
     * 审核状态
     */
    private Integer linkAudit;

    /**
     * 链接图片
     */
    private String linkImage;

    /**
     * 链接描述
     */
    private String linkDescription;

    /**
     * XFN关系
     */
    private String linkRel;

    /**
     * XFN注释
     */
    private String linkNotes;

    /**
     * RSS地址
     */
    private String linkRss;

}
