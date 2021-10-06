package Domain.entities.CronJob;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MyTask {
    public static void main(String[] args) {
        try {
            JobDetail jobRecomendacionSemanal = JobBuilder.newJob(RecomendacionSemanal.class)
                    .withIdentity("RecomendacionSemanal", "group1").build();

            Trigger triggerRecomendacionSemanal = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(1, 13, 00))   //se ejecuta semanalmente
                    .build();

            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobRecomendacionSemanal, triggerRecomendacionSemanal);

            Thread.sleep(100000);

            scheduler.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
