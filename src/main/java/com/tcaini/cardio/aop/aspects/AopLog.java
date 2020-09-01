package com.tcaini.cardio.aop.aspects;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class AopLog {

    private static final String START_TIME="request_start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.tcaini.cardio.aop.controller.*Controller.*(..))")
    public void log(){

    }

    /**
     * 前置操作
     * @param point
     */
    @Before("log()")
    public void beforeLog(JoinPoint point){
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= Objects.requireNonNull(attributes).getRequest();

        log.info("【请求URL】:{}", request.getRequestURL());
        log.info("【请求IP】:{}", request.getRemoteAddr());
        log.info("【请求类名】:{}, 【请求方法名】:{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

        Map<String, String[]> parameterMap=request.getParameterMap();
        log.info("【请求参数】:{}", JSONUtil.toJsonStr(parameterMap));
        Long start=System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object result=point.proceed();
        log.info("【返回值】:{}", JSONUtil.toJsonStr(result));
        return result;
    }

    @AfterReturning("log()")
    public void afterReturning(){
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= Objects.requireNonNull(attributes).getRequest();

        Long start=(Long) request.getAttribute(START_TIME);
        log.info("【请求耗时】:{}", (System.currentTimeMillis()-start));
    }
}
