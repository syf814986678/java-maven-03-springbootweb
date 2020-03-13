package com.shiyfian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
    @RequestMapping("/userlist")
    public List<Map<String,Object>> userlist(){
        String sql="select * from login";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @RequestMapping("/adduser")
    public String adduser(){
        String sql="insert into login values('ceshi','ceshi','123.0','0')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }
}
