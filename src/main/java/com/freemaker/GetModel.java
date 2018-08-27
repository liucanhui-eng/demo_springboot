package com.freemaker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GetModel {
    //给我模板路径,模板名， 数据，自动生成页面
    public static void   getModel(Map data, String modelPath,String modelName, HttpServletResponse response){
        //创建config
        Configuration conf=new Configuration(Configuration.VERSION_2_3_28);
        //设置模板加载路径
        conf.setClassForTemplateLoading(GetModel.class,modelPath);
        try {
            //获取模板
            Template template = conf.getTemplate(modelName, "utf-8");
            //数据

            //输出
            template.process(data, response.getWriter());
        }catch (IOException e){
            System.err.println("文件路径错误");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //给我模板路径,模板名， 数据，自动生成页面
    public static void   getModel(Map data, String modelPath,String modelName, String targetPath){
        //创建config
        Configuration conf=new Configuration(Configuration.VERSION_2_3_28);
        //设置模板加载路径
        conf.setClassForTemplateLoading(GetModel.class,modelPath);
        try {
            //获取模板
            Template template = conf.getTemplate(modelName, "utf-8");

            //获取当前路径

            //输出
            template.process(data,new FileWriter(new File(targetPath)));
        }catch (IOException e){
            System.err.println("文件路径错误");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
