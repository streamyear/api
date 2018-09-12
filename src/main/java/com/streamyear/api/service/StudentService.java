package com.streamyear.api.service;

import com.streamyear.api.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 根据姓名来查询学生
     * @param name
     * @return
     */
    List<Student> listStudentByName(String name);
}
