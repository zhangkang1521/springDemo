package org.zk;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.zk.config.MvcConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 替代web.xml配置
 * Created by Administrator on 4/20/2018.
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MvcConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        // 文件上传配置
        String location = null;
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(location);
        servlet.setMultipartConfig(multipartConfigElement);
        // 开启servlet3.0 异步支持
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
    }
}
