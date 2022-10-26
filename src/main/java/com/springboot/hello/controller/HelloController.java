package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String hello(){
        return "Hollo World";
    }
    @GetMapping(value = "/name")
    public String getName(){
        return "JiYeong";
    }
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable(@PathVariable("variable") String var){
        return var;

    }
}
