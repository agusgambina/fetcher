package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"app.github", "app.common", "app.greenfuture", "app.vonmises", "app.freetochoose"})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}