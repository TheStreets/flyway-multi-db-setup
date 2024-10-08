package com.demo.flywaytest.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MariaDBConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.input")
    public DataSourceProperties inputDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "mariaDBDataSource")
    public DataSource mariaDBDataSource() {
        return inputDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
