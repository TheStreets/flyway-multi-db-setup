package com.demo.flywaytest.config;

import com.demo.flywaytest.output.BaseOutputReference;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackageClasses = BaseOutputReference.class,
        entityManagerFactoryRef = "outputEntityManagerFactory",
        transactionManagerRef = "outputTransactionManager"
)
public class PostgresJpaConfig {

    @Primary
    @Bean("outputEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean outputEntityManagerFactory(@Qualifier("postgresDataSource") DataSource postgresDataSource,
                                                                             EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        return builder.dataSource(postgresDataSource).packages(BaseOutputReference.class).properties(properties).build();
    }

    @Primary
    @Bean("outputTransactionManager")
    public PlatformTransactionManager outputTransactionManager(@Qualifier("outputEntityManagerFactory") LocalContainerEntityManagerFactoryBean outputEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(outputEntityManagerFactory.getObject()));
    }
}
