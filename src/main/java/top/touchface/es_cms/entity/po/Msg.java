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
 * 审核消息
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_msg")
public class Msg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "msg_id", type = IdType.AUTO)
    private Long msgId;

    /**
     * 审核人员ID
     */
    private Long msgSendUid;

    /**
     * 发布人员ID
     */
    private Long msgReciveUid;

    /**
     * 审核信息
     */
    private String msgContent;

    /**
     * 信息状态
     */
    private Integer msgStatus;

    /**
     * 内容ID
     */
    private Long msgRelatedId;

    /**
     * 内容类型
     */
    private Integer msgRelatedType;

    /**
     * 消息发送时间
     */
    private LocalDateTime msgTime;

}
