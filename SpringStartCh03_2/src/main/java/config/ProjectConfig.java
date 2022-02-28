package config;

import domains.Parrot;
import domains.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }
    @Bean
    public Person person(Parrot parrot){ // spring injects the parrot beans into this parameter
        Person p = new Person();
        p.setName("Ella");
        //set relationship person-parrot
        p.setParrot(parrot());
        return p;
    }
}
