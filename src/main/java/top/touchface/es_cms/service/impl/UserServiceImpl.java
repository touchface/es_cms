package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.User;
import top.touchface.es_cms.mapper.UserMapper;
import top.touchface.es_cms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户实体，用户保存用户基本信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
