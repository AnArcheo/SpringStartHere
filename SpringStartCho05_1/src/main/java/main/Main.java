package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("before retrieving the CommentService");
        var service = context.getBean(CommentService.class); // first reference to the bean
        System.out.println("After retrieving the Comment Service");

        //prints:
//        before retrieving the CommentService
//        Comment service created!
//        After retrieving the Comment Service
    }
}
