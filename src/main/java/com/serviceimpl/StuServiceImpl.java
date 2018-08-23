package com.serviceimpl;

import com.model.dao.StudentMapper;
import com.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StuServiceImpl implements StuService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean register(Student student) {

        return studentMapper.insert(student) == 1;
    }

    @Override
    public boolean updateStudent(Student student) {
        int i = studentMapper.updateByPrimaryKeySelective(student);
        return i == 1;
    }

    @Override
    public boolean delStudentById(String id) {
        int i = 0;
        try {
            int key = Integer.valueOf(id);
            i = studentMapper.deleteByPrimaryKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i == 1;
    }

    @Override
    public List<Student> queryAllStudent() {
        return studentMapper.queryAll();
    }

    @Override
    public List<Student> queryStudentByExample(Student student) {
        Map<String, Object> map = new HashMap<>();
        Class stuClass = student.getClass();
        Field[] fields = stuClass.getFields();
        for (Field field : fields) {
            if (field != null && field.toString() != "") {
                String mname = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method method = null;
                try {
                    method = stuClass.getDeclaredMethod(mname);
                    if (method != null) {
                        map.put(field.getName(), method.invoke(student));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        return studentMapper.selectBySelective(map);
    }
}
