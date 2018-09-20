package com.streamyear.api.controller;

import com.streamyear.api.consumer.DemoMqContent;
import com.streamyear.api.pojo.Student;
import com.streamyear.api.pojo.User;
import com.streamyear.api.service.StudentService;
import io.github.rhwayfun.springboot.rocketmq.starter.common.DefaultRocketMqProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private DefaultRocketMqProducer producer;

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
    public void mqTest(){
        DemoMqContent content = new DemoMqContent();
        content.setId(1);
        content.setDesc("您好啊!");
        Message msg = new Message("test-topic","test-tag",content.toString().getBytes());
        boolean b = producer.sendMsg(msg);
        LOGGER.info("发送结果: " + b);
    }
}
