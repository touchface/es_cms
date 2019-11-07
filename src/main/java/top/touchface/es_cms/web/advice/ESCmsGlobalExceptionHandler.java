package top.touchface.es_cms.web.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.touchface.es_cms.entity.vo.ResultVO;
import top.touchface.es_cms.exception.ESCmsException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ESCmsGlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 统一处理内容管理系统异常
     * @param request 请求对象
     * @param exception 异常对象
     * @return 结果视图
     */
    @ExceptionHandler(value = ESCmsException.class)
    public ResultVO ESCmsExceptionHandler(HttpServletRequest request, ESCmsException exception){
        logger.info(exception.getMessage());
        return new ResultVO(exception.getMessage());
    }
}
