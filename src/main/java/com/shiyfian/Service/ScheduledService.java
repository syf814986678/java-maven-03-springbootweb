package com.shiyfian.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //cron表达式
    //秒 分 时 日 月 周几
    /*
        30 0/5 10,18 * * ? 每天10点和18点，每隔5分钟执行一次
    */
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduledhello(){
        System.out.println("hello,你被执行了");
    }
}
