package com.shiyfian;

import com.shiyfian.Service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class JavaMaven03SpringbootwebApplicationTests {
    @Autowired
    SendMailService sendmail;
    @Test
    void contextLoads() throws MessagingException {
        //一个简单的邮件
        sendmail.sendmail("简单邮件测试", "这是一个简单邮件的测试", "814986678@qq.com","814986678@qq.com");
    }
    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        sendmail.sendmail("复杂邮件测试", "这是一个复杂邮件测试", true, "1.jpg", "C:\\Users\\81498\\Pictures\\Camera Roll\\1.jpg","814986678@qq.com", "814986678@qq.com");
    }



}
