package com.freemaker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ServiceModel {


    private static Properties properties = new Properties();
    static{
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ServiceModel.class.getClassLoader().getResourceAsStream("config/application.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String entity = properties.getProperty("Entity");



    public static void main(String[] args) {
        createServiceModel();
        createServiceImplModel();

    }


    public static void createServiceModel(){

        //获取key对应的value值

//        Map<String,Object> map=new HashMap<>();
//        map.put("package",properties.get("package"));
//        map.put("entity",properties.get("entity"));
//        map.put("Entity",properties.get("Entity"));
        Map map = setMapData("servicePackage", "entity", "Entity","serviceName");

        String targetPath=getFilePath("service/")+"/"+entity+"Service.java";
        GetModel.getModel(map,"/ftl","ServiceModel.ftl",targetPath);
    }

    public static void createServiceImplModel(){

//        Map<String,Object> map=new HashMap<>();

        Map map = setMapData("serviceImplPackage","entity","Entity");


        String targetPath=getFilePath("serviceImpl/")+"/"+entity+"ServiceImpl.java";
        GetModel.getModel(map,"/ftl","ServiceImpl.ftl",targetPath);
    }


    public static String getFilePath(String dir){
        File file=new File("src/main/java/com/"+dir);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getPath();
    }


    public static  Map setMapData(String ... keys){
        Map <String,Object> map=new HashMap<>();
        for (String key : keys) {
            map.put(key,properties.get(key));
        }
        return map;
    }



}
