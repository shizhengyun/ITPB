package com.itp.controller;

import com.itp.entity.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";     //返回格式
    private final AtomicLong counter = new AtomicLong();  //线程安全的Long

    @RequestMapping("/greeting")   //设置访问路径
    //设置一个请求参数name，不传则默认传“World”字符串
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //简单的返回一个Greeting实例，而Spring会将其转化为JSON格式
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}