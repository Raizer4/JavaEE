package aop.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlerAspect {

    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetExceptionHandlerAdvice(){
        System.out.println("beforeGetExceptionHandlerAdvice: ловим/обрабатываем " +
                "исключения при попытке получить книгу");
    }

}
