package top.touchface.es_cms.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>
 *  Spring配置文件，用于在启动时加载spring配置文件
 * </p>
 *
 * @author touchface
 * @since 2019-09-26
 */
@Configuration
@ImportResource(value = "classpath*:spring/spring-*.xml")
public class SpringConfig {
}
