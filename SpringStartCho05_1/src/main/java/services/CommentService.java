package services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy // spring will create instance when reference to the bean will be used
public class CommentService {
    public CommentService() {
        System.out.println("Comment service created!");
    }
}
