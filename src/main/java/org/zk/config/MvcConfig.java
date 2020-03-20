package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.zk.convert.MyMessageConvert;
import org.zk.interceptor.DemoInterceptor;

import java.util.List;

/**
 * Created by Administrator on 4/20/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.zk")
public class MvcConfig extends WebMvcConfigurerAdapter{


    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 将 /* 映射到 /* 如何写？
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/toDefer").setViewName("/defer");
    }

    // 文件上传配置这样不行，改用在servlet中配置MultipartConfigElement
//    @Bean
//    public MultipartResolver multiPartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(10*1024*1024); // 10M
//        return multipartResolver;
//    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(demoObjConvert());
    }

    @Bean
    public MyMessageConvert demoObjConvert() {
        return new MyMessageConvert();
    }

}
