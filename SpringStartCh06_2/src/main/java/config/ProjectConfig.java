package config;

import aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "services")
@EnableAspectJAutoProxy
public class ProjectConfig {
    //add instance of the LoggingAspect class to spring context
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
