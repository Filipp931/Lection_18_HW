package com.cooking.recipe.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/cooking?currentSchema=recipes",
                "root","admin");
    }

    @Bean
    public JdbcTemplate recipeJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate recipeNamedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
