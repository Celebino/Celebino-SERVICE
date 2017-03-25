import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;



@Configuration
// Procura por componentes a partir desse pacote.
@ComponentScan(basePackages = "com.celebino")
// Ativa o Spring Data JPA
@EnableJpaRepositories
public class Config {

}