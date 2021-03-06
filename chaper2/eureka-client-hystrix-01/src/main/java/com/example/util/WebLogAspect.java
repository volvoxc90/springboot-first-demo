package com.example.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zhugp
 * @create 2018-04-08 9:53
 **/
@Aspect
@Component
class WebLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.example..web.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        LOG.info("请求地址 : [{}], HTTP METHOD : [{}]" , request.getRequestURL().toString(), request.getMethod());
        LOG.info("IP : [{}]" , request.getRemoteAddr());
        LOG.info("CLASS_METHOD : [{}].[{}]" , joinPoint.getSignature().getDeclaringTypeName() , joinPoint.getSignature().getName());
        LOG.info("参数 : [{}]" , Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOG.info("返回值 : [{}]" , ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        LOG.info("耗时 : [{}]" , (System.currentTimeMillis() - startTime));
        return ob;
    }
}