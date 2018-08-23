package com.freemaker;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServiceModel {
    public static void main(String[] args) {
        createModel("interface");
    }


    public static void createModel(String fileName){
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ServiceModel.class.getClassLoader().getResourceAsStream("config/application.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取key对应的value值
        String interfaceName = properties.getProperty(fileName);
        Map<String,Object> map=new HashMap<>();
        map.put("package",properties.get("package"));
        map.put("entity",properties.get("entity"));
        map.put("Entity",properties.get("Entity"));

        String targetPath="src/main/java/com/"+interfaceName;
        GetModel.getModel(map,"/ftl","ServiceModel.ftl",targetPath);
    }


}
