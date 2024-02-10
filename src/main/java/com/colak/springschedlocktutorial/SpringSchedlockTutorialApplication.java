package com.colak.springschedlocktutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringSchedlockTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedlockTutorialApplication.class, args);
	}

}
