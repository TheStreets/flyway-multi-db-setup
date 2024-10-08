package com.demo.flywaytest.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(@Qualifier("postgresDataSource") DataSource postgresDataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(postgresDataSource)
                .locations("classpath:db/migration/")
                .load();

        flyway.migrate();
        return flyway;
    }

}
