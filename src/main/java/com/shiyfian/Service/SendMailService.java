package com.shiyfian.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailService {
    @Autowired
    JavaMailSender javaMailSender;
    public String sendmail(String Title,String text,String sendto,String sendfrom) throws MessagingException {
        return sendmail(Title, text, false, null, null, sendto, sendfrom);

    }
    public String sendmail(String Title, String text,Boolean multipart,String filename,String filepath,String sendto, String sendfrom) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,multipart);
        helper.setSubject(Title);
        helper.setText(text, true);
        if(multipart){
            helper.addAttachment(filename, new File(filepath));
        }
        helper.setTo(sendto);
        helper.setFrom(sendfrom);
        javaMailSender.send(mimeMessage);
        return "OK";

    }
}
