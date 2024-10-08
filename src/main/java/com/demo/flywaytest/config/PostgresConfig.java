package com.demo.flywaytest.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresConfig {


    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.output")
    public DataSourceProperties outputDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "postgresDataSource")
    @FlywayDataSource
    public DataSource postgresDataSource() {
        return outputDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
