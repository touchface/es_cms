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
 * 定义系统拥有的功能菜单
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cms_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单主键
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 父级菜单主键
     */
    private Long menuParent;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单链接
     */
    private String menuUrl;

    /**
     * 菜单状态:0：禁用，1：启用
     */
    private Integer menuStatus;

}
