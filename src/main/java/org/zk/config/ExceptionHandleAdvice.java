package org.zk.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



/**
 * Created by Administrator on 4/20/2018.
 */
@ControllerAdvice
public class ExceptionHandleAdvice {

    // 统一异常处理
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception, WebRequest webRequest) {
        // 这里如何判断ajax返回还是页面返回
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMsg", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("msg", "model attribute add!");
    }

    @InitBinder
    public void initBind(WebDataBinder webDataBinder) {
        // 表单到实体类的转换
        // 对requestBody不起作用，requestBody使用MessageConverter
        webDataBinder.setDisallowedFields("id");
    }
}
