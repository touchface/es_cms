package top.touchface.es_cms.service.impl;

import top.touchface.es_cms.entity.po.Term;
import top.touchface.es_cms.mapper.TermMapper;
import top.touchface.es_cms.service.ITermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类项信息 服务实现类
 * </p>
 *
 * @author touchface
 * @since 2019-10-28
 */
@Service
public class TermServiceImpl extends ServiceImpl<TermMapper, Term> implements ITermService {

}
