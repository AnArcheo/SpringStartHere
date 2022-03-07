package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var b1 = context.getBean("commentService", CommentService.class);
        var b2 = context.getBean("commentService", CommentService.class);

        boolean bool = b1==b2;
        System.out.println(bool);
    }
}
