package kr.co.ubcn.welpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@SpringBootApplication
public class WelpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(WelpointApplication.class, args);
    }

}
