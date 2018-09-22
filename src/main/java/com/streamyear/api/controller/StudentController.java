package com.streamyear.api.controller;

import com.streamyear.api.pojo.Student;
import com.streamyear.api.pojo.User;
import com.streamyear.api.service.StudentService;
import com.streamyear.api.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("listStudentByName")
    public List<Student> listStudentByName(){
        List<Student> result = studentService.listStudentByName("小王");
        return result;
    }

    @RequestMapping("user")
    public User listUser(Date date){
        System.out.println(date);
        User user = studentService.listUser();
        return user;
    }

    @RequestMapping("log")
    public void logTest(){
        LOGGER.info("info消息!!!");
        LOGGER.debug("debug消息!!!");
        LOGGER.error("error消息!!!");
    }

    @RequestMapping("mq")
    public String mqTest() throws Exception {
        amqpTemplate.convertAndSend("sendSMS", "manager", "么么么么木");
        System.out.println("发送成功!");
        return "ok";
    }
}
