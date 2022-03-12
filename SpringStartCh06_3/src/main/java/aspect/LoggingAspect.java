package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)") // intercept methods annotated with the custom annotation
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName +
                " with parameters: " + Arrays.asList(arguments));

        Object returnedByMathod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMathod);

        return returnedByMathod;
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }
}
