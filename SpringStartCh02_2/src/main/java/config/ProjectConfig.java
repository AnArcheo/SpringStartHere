package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "domains") // if class is annotated as Component then ComponentScan tells
                                         // spring where to look for classes
public class ProjectConfig {             // no need for methods to define beans
}
