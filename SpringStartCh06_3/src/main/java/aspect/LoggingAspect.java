package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)") // intercept methods annotated with the custom annotation
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Logging Aspect: Method " + methodName +
                " with parameters: " + Arrays.asList(arguments));

        Object returnedByMethod = joinPoint.proceed();

        logger.info("Logging Aspect: Method executed and returned " + returnedByMethod);

        return returnedByMethod;
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }
}
