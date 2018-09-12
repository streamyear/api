package com.streamyear.api.controller;

import com.streamyear.api.pojo.Student;
import com.streamyear.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("listStudentByName")
    public List<Student> listStudentByName(){
        List<Student> result = studentService.listStudentByName("小王");
        return result;
    }
}
