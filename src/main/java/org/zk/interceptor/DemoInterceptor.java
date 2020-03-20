package org.zk.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 4/20/2018.
 */
public class DemoInterceptor /*extends HandlerInterceptorAdapter*/ {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoInterceptor.class);

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        LOGGER.info("=== preHandle ===");
//        return true;
//    }
//
//    @Override
//    public void postHandle(
//            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
//            throws Exception {
//        LOGGER.info("=== postHandle ===");
//    }

}
