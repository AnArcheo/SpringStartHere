package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //method to implement the aspect logic,
    // and use advice annotation to tell Spring when and what to intercept
    @Around("execution(* services.*.*(..))") // defines which are intecepted methods
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute"); // prints message before intercepted methods executes
        joinPoint.proceed(); //call intercepted method
        logger.info("Method executed"); // print message after intercepted methods execution
    }
}
