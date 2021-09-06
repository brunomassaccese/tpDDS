package CronJob;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Anda " + new Date());
    }
}
