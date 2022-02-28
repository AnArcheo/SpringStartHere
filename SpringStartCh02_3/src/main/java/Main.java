import config.ProjectConfig;
import domains.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = new Parrot();
        p.setName("Kiki");
        Supplier<Parrot> parrotSupplier = () -> p;//define supplier to return this instance

        context.registerBean("parrot1", Parrot.class, parrotSupplier);// registerBean() to add instance to the Spring context
        //using registerBean() we can set this bean as Primary like:
        //context.registerBean("parrot1", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName()); // prints Kiki
    }
}
