package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //gets the CommentService from the context
        var service = context.getBean(CommentService.class);

        //creates a comment instance to give as a parameter to the publishComment() method
        Comment comment = new Comment();
        comment.setText("Demo Text");
        comment.setAuthor("Anna");

        //Calls the publishComment() method
        service.publishComment(comment);
    }
}
