import config.ProjectConfig;
import domains.Parrot;
import domains.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);//instance of Spring Context based on Config class
        //get reference of the Person and Parrot Bean from the Spring context
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());

        System.out.println("Parrot's name: " + parrot.getName());

        System.out.println("Person's parrot: " + person.getParrot()); // to prove that there is no relationship between the instances
                                                                        // prints null
// output:
//        Person's name: Ella
//        Parrot's name: Koko
//        Person's parrot: null
    }
}
