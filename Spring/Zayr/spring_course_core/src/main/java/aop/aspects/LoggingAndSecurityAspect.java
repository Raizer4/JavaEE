package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

   /* @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allReturnAndGetMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }

    @Before("allReturnAndGetMethodsFromUniLibrary()")
    public void beforeReturnAndGetLoggingAdvice(){
        System.out.println("beforeReturnAndGetLoggingAdvice: writing Log #3");
    }*/








}
