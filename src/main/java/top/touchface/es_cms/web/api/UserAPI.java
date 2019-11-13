package top.touchface.es_cms.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.touchface.es_cms.entity.po.User;
import top.touchface.es_cms.entity.vo.ResultVO;
import top.touchface.es_cms.exception.ESCmsException;

/**
 * <p>
 * 用户处理数据接口
 * </p>
 *
 * @author touchface
 * @since 2019/11/3
 */
@RestController
@RequestMapping("api/user")
public class UserAPI {

    /**
     * 用户账号注册
     * @param user 用户信息
     * @return 注册结果
     * @throws ESCmsException 系统异常
     */
    public ResultVO register(User user) throws ESCmsException {

        return new ResultVO("注册失败！");
    }
}
