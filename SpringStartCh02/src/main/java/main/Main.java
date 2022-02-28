package main;

import config.ProjectConfig;
import domains.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // instance of Spring Context and configuration class as parameter to instruct Spring to use it
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //referring to the Parrot instance from the spring context
        // Parrot parrot = context.getBean(Parrot.class);
        // if multiple instances of the same class name of the instance must be provided, otherwise Exception
        Parrot parrot = context.getBean("parrot3",Parrot.class);
        System.out.println(parrot.getName());

//        //Printing two other beans in the console
//        String s = context.getBean(String.class);
//        System.out.println(s);
//
//        Integer n = context.getBean(Integer.class);
//        System.out.println(n);
    }
}
