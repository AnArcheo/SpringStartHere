package domains;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // to annotate class for which Spring will add bean to its context
public class Parrot {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init(){
        this.name = "Koko";
    }
}
