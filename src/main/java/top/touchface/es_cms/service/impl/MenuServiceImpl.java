package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Menu;
import top.touchface.es_cms.mapper.MenuMapper;
import top.touchface.es_cms.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定义系统拥有的功能菜单 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
