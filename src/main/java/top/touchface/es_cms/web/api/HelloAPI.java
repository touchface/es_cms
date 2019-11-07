package top.touchface.es_cms.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.touchface.es_cms.entity.vo.ResultVO;

/**
 * <p>
 * 连接测试接口
 * </p>
 *
 * @author touchface
 * @since 2019/10/30
 */
@RestController
@RequestMapping("api/hello")
public class HelloAPI {
    @GetMapping("say-hello")
    @ResponseBody public ResultVO sayHello(){
        return new ResultVO("HELLO WORLD!","HELLO WORLD!");
        // return new ResultVO("HELLO BUG WORLD!");
    }
}
