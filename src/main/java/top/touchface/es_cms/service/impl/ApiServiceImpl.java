package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Api;
import top.touchface.es_cms.mapper.ApiMapper;
import top.touchface.es_cms.service.IApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据接口信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-07
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements IApiService {

}
