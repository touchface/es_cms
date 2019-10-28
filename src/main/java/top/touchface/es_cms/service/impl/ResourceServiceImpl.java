package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Resource;
import top.touchface.es_cms.mapper.ResourceMapper;
import top.touchface.es_cms.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容管理系统资源信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
