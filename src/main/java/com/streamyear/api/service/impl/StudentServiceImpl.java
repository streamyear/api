package com.streamyear.api.service.impl;

import com.streamyear.api.mapper.StudentMapper;
import com.streamyear.api.mapper.UserMapper;
import com.streamyear.api.pojo.Student;
import com.streamyear.api.pojo.User;
import com.streamyear.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Student> listStudentByName(String name) {
        return studentMapper.listByName(name);
    }

    @Override
    public User listUser() {
        return userMapper.selectByPrimaryKey(1L);
    }
}
