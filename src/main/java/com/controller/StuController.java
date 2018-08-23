package com.controller;


import com.freemaker.GetModel;
import com.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController()
@RequestMapping("/stu")
public class StuController {
    @Autowired
    StuService stuService;
    @RequestMapping("queryAll")
    public void queryAll(HttpServletResponse response){
        List<Student> students = stuService.queryAllStudent();
//        Student student = students.get(0);
        HashMap<String, Object> map = new HashMap<>();
       /* map.put("id",student.getId());
        map.put("name",student.getName());
        map.put("age",student.getAge());*/
       map.put("stuList",students);
        GetModel.getModel(map,"/ftl","demo.txt",response);
    }
    /*//获取模板
    public void getModel()throws Exception {
        //创建config
        Configuration conf=new Configuration(Configuration.VERSION_2_3_28);
        //设置模板加载路径
        conf.setClassForTemplateLoading(StuController.class,"/ftl");
        //获取模板
        Template template = conf.getTemplate("demo.txt", "utf-8");
        //数据
        Map<String,Object> data=new HashMap();
        //输出
        template.process(data,new FileWriter(new File("F:/abc.txt")));

    }*/


}
