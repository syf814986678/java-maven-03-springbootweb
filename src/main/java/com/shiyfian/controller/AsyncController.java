package com.shiyfian.controller;

import com.shiyfian.Service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//异步任务
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @GetMapping("/async")
    public String async(){
        asyncService.hello();
        return "ok";
    }
}
