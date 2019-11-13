package top.touchface.es_cms.web.listener;
import top.touchface.es_cms.web.context.ESCmsContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * <p>
 * ES_CMS系统启动监听器
 * </p>
 *
 * @author touchface
 * @since 2019/9/26
 */
@WebListener
public class ESCmsContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化ES_CMS系统应用上下文
        ESCmsContext.init(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 销毁ES_CMS上下文
        ESCmsContext.destroyed();
    }
}
