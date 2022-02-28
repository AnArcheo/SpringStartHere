package config;

import domains.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean
    @Primary //this bean will be chosen if no bean will be specified in the context - this is the default bean
    Parrot parrot1(){
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }
    //Add other beans to the context
    @Bean
    String hello(){
        return "Hello";
    }
    @Bean
    Integer ten(){
        return 10;
    }

    //Adding multiple beans of the same type to the Spring Context
    @Bean
    Parrot parrot2(){
        var p = new Parrot();
        p.setName("Mikki");
        return p;
    }

    @Bean(name = "riki") //== (value="riki") or ("riki") -> setting the name of the bean
    Parrot parrot3(){
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }
}
