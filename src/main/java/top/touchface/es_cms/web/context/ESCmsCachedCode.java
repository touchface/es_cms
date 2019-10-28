package top.touchface.es_cms.web.context;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * ESCMS系统缓存的码值集合
 * </p>
 *
 * @author touchface
 * @since 2019/9/26
 */
public class ESCmsCachedCode {

    private Map<String,Map> codes=new HashMap<>();// 用于存放系统中的所有码值

    public Map<String, Map> getCodes() {
        return codes;
    }

    public void setCodes(Map<String, Map> codes) {
        this.codes = codes;
    }
}
