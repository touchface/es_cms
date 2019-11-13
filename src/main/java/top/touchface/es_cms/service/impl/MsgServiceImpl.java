package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Msg;
import top.touchface.es_cms.mapper.MsgMapper;
import top.touchface.es_cms.service.IMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核消息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-11-07
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements IMsgService {

}
