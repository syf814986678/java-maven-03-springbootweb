package com.shiyfian.Config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language=request.getParameter("l");//获取请求中的语言参数
        Locale locale = Locale.getDefault();//如果没有使用默认
        if(!StringUtils.isEmpty(language)){
            //如果请求连接携带了国际化的参数
            String[] split = language.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
