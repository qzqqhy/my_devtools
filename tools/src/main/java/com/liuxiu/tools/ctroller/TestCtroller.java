package com.liuxiu.tools.ctroller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController("/testc")
public class TestCtroller {

    @RequestMapping
    @ResponseBody
    public String test1() {
        return "oktest";
    }
    @RequestMapping(name = "/t1")
    @ResponseBody
    public String test() {
        return "ok";
    }
}
