package com.openshift.metrics;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class MetricJob implements Job {

    public void execute(JobExecutionContext context)
    throws JobExecutionException {
        //Get the metrics here
    }
}
