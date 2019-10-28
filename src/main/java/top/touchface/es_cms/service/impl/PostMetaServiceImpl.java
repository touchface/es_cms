package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.PostMeta;
import top.touchface.es_cms.mapper.PostMetaMapper;
import top.touchface.es_cms.service.IPostMetaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用于保存用户的拓展信息，键值对形式 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class PostMetaServiceImpl extends ServiceImpl<PostMetaMapper, PostMeta> implements IPostMetaService {

}
