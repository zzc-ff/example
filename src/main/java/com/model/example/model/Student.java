package com.model.example.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Student {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Max(value = 120, message = "年龄太大，最大120")
    @Min(value = 1, message = "年龄太小，最小一岁")
    private int age;
    @NotBlank(message = "性别不能为空")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
