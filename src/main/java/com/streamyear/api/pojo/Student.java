package com.streamyear.api.pojo;

import lombok.*;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private String city;

    private Integer age;

}
