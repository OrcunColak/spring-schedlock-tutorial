package com.colak.springschedlocktutorial.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ColakTaskScheduler {

    private static final String LOCK_NAME = "scheduledTask_lock_name";

    // Every 10 seconds
    private static final String CRON = "*/10 * * * * *";

    // every 1 minutes
    @Scheduled(cron = CRON)
    @SchedulerLock(name = LOCK_NAME, lockAtLeastFor = "PT15S", lockAtMostFor = "PT30S")
    public void scheduledTask1() {
        log.info("Executing scheduledTask 1");
        sleepRandom();
    }

    @Scheduled(cron = CRON)
    @SchedulerLock(name = LOCK_NAME)
    public void scheduledTask2() {
        log.info("Executing scheduledTask 2");
        sleepRandom();
    }

    @Scheduled(fixedRateString = "15", timeUnit = TimeUnit.SECONDS)
    @SchedulerLock(name = "RoutineScheduler.scheduledTask", lockAtLeastFor = "PT15S", lockAtMostFor = "PT30S")
    public void scheduledTask() {
        log.info("Scheduler open: " + LocalDateTime.now());
    }

    @SuppressWarnings("java:S2142")
    private void sleepRandom() {
        int timeout = ThreadLocalRandom.current().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException exception) {
            log.info("Interrupted!", exception);
        }
    }
}
