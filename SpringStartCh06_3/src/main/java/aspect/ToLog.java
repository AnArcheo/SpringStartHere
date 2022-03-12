package aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom Annotation accessible at runtime

@Retention(RetentionPolicy.RUNTIME) // annotation to be intercepted at runtime
@Target(ElementType.METHOD) // restrict this annotation to only be used with methods
public @interface ToLog {
}
