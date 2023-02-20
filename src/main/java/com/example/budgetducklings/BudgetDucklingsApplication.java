package com.example.budgetducklings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableJdbcHttpSession
@EnableWebMvc
@SpringBootApplication
public class BudgetDucklingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetDucklingsApplication.class, args);
    }

}
