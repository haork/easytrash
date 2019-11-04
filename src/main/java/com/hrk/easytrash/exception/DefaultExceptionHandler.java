package com.hrk.easytrash.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hrk
 * @Date: 2019-11-04 21:10
 * @Description:
 */
@Slf4j
@Component
public class DefaultExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error("发生异常啦:" + e.getMessage(), e);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 500);
        data.put("msg", e.getMessage());

        return new ModelAndView(new MappingJackson2JsonView(), data);
    }
}
