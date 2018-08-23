package com.model.dao;

import com.model.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    List<Student> selectBySelective(Map<String,Object> map);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //查询所有
    List<Student> queryAll();

}