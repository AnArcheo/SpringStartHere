package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    // because here is one constructor @Autowired is optional
    // Spring uses this constructor to create the bean and injects
    // references from its context in the parameter
    //when creating the instance
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        //to use specific implementation annotate parameter with @Qualifier
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    //use case that delegates the "store comment" and "send notification"
    //responsibilities to the dependencies
    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
