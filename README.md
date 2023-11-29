# About This Project
This project showcased the implementation of **SchedLock** with **Hazelcast** as its provider.  

Two cron jobs, each running every **10** seconds, attempt to acquire the same lock name.   

Log entries reveal that either **scheduledTask1** or **scheduledTask2** successfully acquires the lock, 
resulting in alternating execution.

