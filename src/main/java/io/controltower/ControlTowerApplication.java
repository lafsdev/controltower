package io.controltower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class

ControlTowerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ControlTowerApplication.class, args);
    }

    @Configuration
    public static class MvcConfig extends WebMvcConfigurerAdapter {
        public void addViewControllers(ViewControllerRegistry registry){
            registry.addRedirectViewController("/", "/rotas");
        }
    }

}