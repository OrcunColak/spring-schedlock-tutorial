package com.colak.springschedlocktutorial;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
// PT (Parsing Time) 30 seconds
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class SpringSchedlockTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedlockTutorialApplication.class, args);
	}

}
