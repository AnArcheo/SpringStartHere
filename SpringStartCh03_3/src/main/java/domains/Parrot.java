package domains;

import org.springframework.stereotype.Component;

@Component  //instruct Spring to create and add Bean to the context
public class Parrot {
    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}