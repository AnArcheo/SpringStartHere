import config.ProjectConfig;
import domains.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class); //Befor adding @PostConstruct to Parrot class:
        System.out.println(p);           // prints default Spring representation of instance taken from spring context:domains.Parrot@54a7079e
        System.out.println(p.getName()); // prints null because no name was specified in the Parrot instance// after
        //after @PostConstruct name is set to Koko
    }
}
