package com.colak.springschedlocktutorial.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.hazelcast4.HazelcastLockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
// PT means Parsing Time and PT30S means 30 seconds
// The parameter defaultLockAtMostFor provides a default limit of time to lock our tasks, but we can override it in the task’s declaration.
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class SchedLockConfiguration {

    @Bean
    public Config hazelcastConfig() {
        return Config.loadDefault();
    }

    @Bean
    @Profile("hazelcast")
    public HazelcastLockProvider hazelcastLockProvider(HazelcastInstance hazelcastInstance) {
        return new HazelcastLockProvider(hazelcastInstance);
    }

    @Bean
    public LockProvider jdbcLockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource);
    }
}
