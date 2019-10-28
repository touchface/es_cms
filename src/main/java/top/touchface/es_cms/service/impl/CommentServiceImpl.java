package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Comment;
import top.touchface.es_cms.mapper.CommentMapper;
import top.touchface.es_cms.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 保存用户评论信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
