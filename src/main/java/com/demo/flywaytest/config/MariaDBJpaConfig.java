package com.demo.flywaytest.config;

import com.demo.flywaytest.input.BaseInputReference;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = BaseInputReference.class,
        entityManagerFactoryRef = "inputEntityManagerFactory",
        transactionManagerRef = "inputTransactionManager"
)
public class MariaDBJpaConfig {

    @Bean("inputEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean inputEntityManagerFactory(@Qualifier("mariaDBDataSource") DataSource mariaDBDataSource,
                                                                             EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");

        return builder.dataSource(mariaDBDataSource).packages(BaseInputReference.class).properties(properties).build();
    }


    @Bean("inputTransactionManager")
    public PlatformTransactionManager inputTransactionManager(@Qualifier("inputEntityManagerFactory") LocalContainerEntityManagerFactoryBean inputEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(inputEntityManagerFactory.getObject()));
    }
}
