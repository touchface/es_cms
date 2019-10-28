package top.touchface.es_cms.web.context;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.touchface.es_cms.common.util.CMSLogger;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * <p>
 * ES_CMS内容管理系统上下文对象
 * </p>
 *
 * @author touchface
 * @since 2019/9/26
 */
public class ESCmsContext {

    private static ESCmsCachedCode ESCmsCachedCode;// ES_CMS管理系统码值对象
    private static ServletContext servletContext;// 上下文对象
    private static WebApplicationContext webApplicationContext;// spring上下文对象

    /**
     * 初始化应用上下文
     * @param sc 应用上下文对象
     */
    public static void init(ServletContext sc) {
        CMSLogger.logger.info("ES_CMS 系统初始化开始");
        servletContext=sc;
        webApplicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContext);
        loadEsCmsCode();
        CMSLogger.logger.info("ES_CMS 系统初始化完成");
    }

    public static void destroyed(){
        CMSLogger.logger.info("ES_CMS 系统关闭");
    }

    /**
     * 从上下文对象中获取码表信息
     */
    private static void loadEsCmsCode(){
        CMSLogger.logger.info("ES_CMS 系统码表加载开始");
        ESCmsCachedCode= (ESCmsCachedCode) webApplicationContext.getBean("ES_CMS_CODE");
        CMSLogger.logger.info("ES_CMS 系统码表加载完成");
    }
    /**
     * 获取指定名称的码表
     * @param codeName 码表名称
     * @return 码表Map
     */
    public static Map getESCmsCode(String codeName){
        if(ESCmsCachedCode==null||ESCmsCachedCode.getCodes()==null){
            return null;
        }
        return ESCmsCachedCode.getCodes().get(codeName);
    }

    /**
     * 获取码值
     * @param codeName 码表名称
     * @param codeKey 码值KEY
     * @return 码值
     */
    public static Object getESCmsCodeValue(String codeName,Object codeKey){
        if(ESCmsCachedCode==null||ESCmsCachedCode.getCodes()==null){
            return null;
        }
        Map code=ESCmsCachedCode.getCodes().get(codeName);
        if(code==null){
            return null;
        }
        return code.get(codeKey);
    }

    /**
     * 获取码表缓存对象
     * @return 码表缓存对象
     */
    public static ESCmsCachedCode getESCmsCachedCode() {
        return ESCmsCachedCode;
    }

    /**
     * 获取应用上下文对象
     * @return 应用上下文对象
     */
    public static ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * 获取Spring上下文对象
     * @return spring上下文
     */
    public static WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }
}
