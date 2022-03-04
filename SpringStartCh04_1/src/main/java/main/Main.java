package main;

import model.Comment;
import proxies.EmailNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        // instances for dependecies
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailNotificationProxy();

        // instance of the service class
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        // instance of comment to send as parameter to the publish comment use case
        var comment = new Comment();
        comment.setAuthor("Anna");
        comment.setText("Test Comment");

        commentService.publishComment(comment);
    }
}
