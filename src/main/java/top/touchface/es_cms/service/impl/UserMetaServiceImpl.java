package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.UserMeta;
import top.touchface.es_cms.mapper.UserMetaMapper;
import top.touchface.es_cms.service.IUserMetaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用于保存用户的拓展信息，键值对形式 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Service
public class UserMetaServiceImpl extends ServiceImpl<UserMetaMapper, UserMeta> implements IUserMetaService {

}
