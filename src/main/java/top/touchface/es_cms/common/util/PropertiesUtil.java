package top.touchface.es_cms.common.util;

import java.io.*;
import java.util.Properties;

/**
 * @author Jason
 * date:2018/12/19 23:20
 * description:
 * 读写Properties文件的工具类
 */
public class PropertiesUtil {
    public static Properties readProperties(String path){
        Properties properties=new Properties();
        InputStream is=null;
        try {
            is=new FileInputStream(path);
            properties.load(is);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 写入Properties文件
     * @param path 路径
     * @param properties 需要保存的Properties对象
     * @return 是否保存成功
     */
    public static boolean writeProperties(String path,Properties properties){

        OutputStream os=null;
        try {
            // 获取将要保存Properties文件的文件夹路径
            String folder=path;
            if(folder.endsWith(".properties")){
                folder=folder.substring(0,folder.lastIndexOf("/"));
                File file=new File(folder);
                if(!file.exists()){
                    file.mkdirs();
                }
            }
            os=new FileOutputStream(path);
            properties.store(os,null);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
