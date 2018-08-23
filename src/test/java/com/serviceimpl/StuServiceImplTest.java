package com.serviceimpl;

import com.model.dao.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StuServiceImplTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void register() {
       // System.out.println(studentMapper.insert(new Student()));
    }

    @Test
    public void queryAll() {
     //   System.out.println(studentMapper.queryAll());
    }
}