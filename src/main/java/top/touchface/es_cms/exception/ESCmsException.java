package top.touchface.es_cms.exception;

import lombok.Data;

/**
 * <p>
 * 自定义异常，用于统一处理异常
 * </p>
 *
 * @author touchface
 * @since 2019/11/3
 */
public class ESCmsException extends Exception{
    public ESCmsException(){
        super();
    }
    public ESCmsException(String msg){
        super(msg);
    }
}
