package com.github.youssefagagg.springdatajdbcdemo.domain;



import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Configuration
@EnableJdbcAuditing
public class AuditingConfiguration {

}
