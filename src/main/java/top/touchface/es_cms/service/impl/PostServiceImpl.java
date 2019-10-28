package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Post;
import top.touchface.es_cms.mapper.PostMapper;
import top.touchface.es_cms.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用于存放发布内容信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
