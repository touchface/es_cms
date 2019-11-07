package top.touchface.es_cms.entity.vo;

import lombok.Data;
import top.touchface.es_cms.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * <p>
 * 结果视图类，用于统一存放返回前端数据结果
 * </p>
 *
 * @author touchface
 * @since 2019/10/30
 */
@Data
public class ResultVO implements Serializable{

    /**
     * 返回结果
     */
    private Object data;

    /**
     * 执行状态：SUCCESS 成功，FAIL 失败
     */
    private ResultEnum status;

    /**
     * 返回执行成功消息
     */
    private String message;

    /**
     * 返回执行失败消息
     */
    private String error;

    /**
     * 无参构造函数
     */
    public ResultVO(){}

    /**
     * 构造方法：返回成功数据
     * @param data 返回的数据对象
     */
    public ResultVO(Object data){
        this.data=data;
        this.message=null;
        this.status=ResultEnum.SUCCESS;
    }
    /**
     * 构造方法：返回成功数据以及成功消息
     * @param data 返回的数据对象
     * @param message 返回成功的消息
     */
    public ResultVO(Object data,String message){
        this.data=data;
        this.message=message;
        this.status=ResultEnum.SUCCESS;
    }

    /**
     * 构造方法：返回异常消息
     * @param error 异常消息
     */
    public ResultVO(String error){
        this.error=error;
        this.status=ResultEnum.FAIL;
    }

    /**
     * 构造方法：返回执行状态以及相应的消息
     * @param status 执行状态
     * @param text 消息
     */
    public ResultVO(ResultEnum status,String text){
        this.status=status;
        if(this.status==ResultEnum.SUCCESS){
            this.message = text;
        }else {
            this.error = text;
        }
    }
}
