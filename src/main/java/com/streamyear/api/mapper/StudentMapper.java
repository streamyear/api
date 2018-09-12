package com.streamyear.api.mapper;

import com.streamyear.api.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> listByName(String name);
}
