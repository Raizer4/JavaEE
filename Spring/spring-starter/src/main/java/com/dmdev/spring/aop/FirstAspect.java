package com.dmdev.spring.aop;

import com.dmdev.spring.service.UserService;
import com.dmdev.spring.validator.impl.UserInfoValidator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Slf4j
@Component
public class FirstAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {}

    @Pointcut("within(com.dmdev.spring.service.*Service)")
    public void isServiceLayer(){}

    @Pointcut("target(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer() {}

    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping(){}

    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelArg(){}

    @Pointcut("isControllerLayer() && @args(com.dmdev.spring.validator.impl.UserInfoValidator,..)")
    public void hasUserInfoParamAnnotation(){}

    @Pointcut("bean(userService)")
    public void isUserServiceBean(){}

    @Pointcut("execution(public * com.dmdev.spring.service.*Service.findById(*))")
    public void anyServiceFindByMethod(){}

    @Pointcut("execution(public * findById(*))")
    public void anyFindByIdMethod(){ }

    @Before("anyServiceFindByMethod() " +
            "&& args(id) " +
            "&& target(service) " +
            "&& this(serviceProxy) " +
            "&& @within(transactional)")
    public void addLogging(JoinPoint joinPoint,
                           Object id,
                           Object service,
                           Object serviceProxy,
                           Transactional transactional){
        log.info("Invoke findById method");
    }

}
