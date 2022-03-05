package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"proxies", "services", "repositories"}) //to tell Sprig which packages search
                                                                        //for classes annotated with stereotype
public class ProjectConfiguration {
}
