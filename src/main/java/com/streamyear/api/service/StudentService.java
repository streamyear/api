package com.streamyear.api.service;

import com.streamyear.api.pojo.Student;
import com.streamyear.api.pojo.User;

import java.util.List;

public interface StudentService {
    /**
     * 根据姓名来查询学生
     * @param name
     * @return
     */
    List<Student> listStudentByName(String name);

    /**
     * 获取用户信息
     * @return
     */
    User listUser();
}
