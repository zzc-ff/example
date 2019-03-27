package com.model.example.controller;

import com.model.example.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("/getList")
    public void  queryList(){
        logger.info("=================进入getList 方法===========================");
        logger.error("----------------我自己制造了一个错误，哈哈------------------");
    }

    /**
     * @RequestBody 表示接受json 格式传值     默认 接受表单传值
     *
     * @param student
     */
    @RequestMapping("/insert")
    public void  insert(@RequestBody @Validated  Student student){

    }
}
