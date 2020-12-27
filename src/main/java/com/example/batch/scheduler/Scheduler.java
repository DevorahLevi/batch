package com.example.batch.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // Generic Version of a Component (@Service and @Controller are both Components)
public class Scheduler
{
    @Scheduled(fixedRate = 5000) //fixedRate means that it runs every x amount of milliseconds. In this case, every 5 seconds.
//                               // initialDelay makes the first execution wait before starting.
//                                 ** fixedDelay vs. fixedRate:
//                                          fixedRate goes every 5 seconds (5 seconds starts from when the execution starts).
//                                          fixedDelay goes every 5 seconds (5 seconds starts from when the execution finishes)
//                                 ** This means that a new execution can start with one still running with a new thread. Becomes a problem if you have too many threads running at once, so fixedDelay is often a better solution.

    public void getCurrentTime() // Similar to a controller, it should only provide access to our app and call a service function, not do any actual logic.
    {
        System.out.println("start" + new Date());
    }
}