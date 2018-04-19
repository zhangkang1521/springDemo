package org.zk.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Administrator on 4/19/2018.
 */
@Component
public class UserService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader resourceLoader;


    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void readProperties() {
        System.out.println("使用ResourceLoader读取文件");
        Resource resource = resourceLoader.getResource("classpath:log4j.properties");
        try {
            List<String> allLines = Files.readAllLines(Paths.get(resource.getURI()));
            allLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
