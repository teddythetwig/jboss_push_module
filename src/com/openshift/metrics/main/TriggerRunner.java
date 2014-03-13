package com.openshift.metrics;
 
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerRunner {
    public static void main(String[] args) {
        JobDetail job = JobBuilder.newJob(MetricJob.class)
            .withIdentity("metricsJob","jbossMetrics")
            .build();
        //How should this interval value be passed???
        Trigger trigger = TriggerBuilder
            .newTrigger()
            .withIdentity("metricsTrigger","jbossMetrics")
            .withSchedule(
                          SimpleScheduleBuilder.simpleSchedule()
                          .withIntervalInSeconds(60).repeatForever())
            .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job,trigger);
    }
}
