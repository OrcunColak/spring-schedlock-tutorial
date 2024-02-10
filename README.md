# About This Project

This project showcased the implementation of **SchedLock** with **Jdbc** and "**Hazelcast** as its provider.

Two cron jobs, each running every **10** seconds, attempt to acquire the same lock name.

Log entries reveal that either **scheduledTask1** or **scheduledTask2** successfully acquires the lock,
resulting in alternating execution.

# Jdbc Provider

The original idea is from  
https://medium.com/@marcoscarneirolima/scheduler-lock-using-spring-shedlock-b9ac3e51a934

