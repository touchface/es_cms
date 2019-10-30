package top.touchface.es_cms.entity.po;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 菜单权限
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_menu_right")
public class MenuRight implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long menuId;

    /**
     * 主键
     */
    private Long roleId;

}
