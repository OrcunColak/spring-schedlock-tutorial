package com.colak.springschedlocktutorial.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import net.javacrumbs.shedlock.provider.hazelcast4.HazelcastLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedLockConfiguration {

    @Bean
    public Config hazelcastConfig() {
        return Config.loadDefault();
    }

    @Bean
    public HazelcastLockProvider lockProvider(HazelcastInstance hazelcastInstance) {
        return new HazelcastLockProvider(hazelcastInstance);
    }
}
