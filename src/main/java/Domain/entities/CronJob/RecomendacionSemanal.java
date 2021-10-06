package Domain.entities.CronJob;

import java.util.List;

import Domain.entities.Organizacion.Organizacion;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RecomendacionSemanal implements Job {
    private List<Organizacion> organizaciones;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        this.organizaciones.forEach(organizacion -> organizacion.recomendar());
    }
}
