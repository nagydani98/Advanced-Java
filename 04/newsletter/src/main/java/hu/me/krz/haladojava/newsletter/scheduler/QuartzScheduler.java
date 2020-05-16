package hu.me.krz.haladojava.newsletter.scheduler;

import java.io.IOException;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import hu.me.krz.haladojava.newsletter.config.AutoWiringSpringBeanJobFactory;

@Configuration
//@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='false'")
public class QuartzScheduler {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
    private ApplicationContext applicationContext;
	
	@Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        logger.debug("Configuring Job factory");

        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
	
	 @Bean
	 public Scheduler scheduler(Trigger trigger, JobDetail job, SchedulerFactoryBean factory) throws SchedulerException {
	        logger.debug("Getting a handle to the Scheduler");
	        Scheduler scheduler = factory.getScheduler();
	        scheduler.scheduleJob(job, trigger);

	        logger.debug("Starting Scheduler threads");
	        scheduler.start();
	        return scheduler;
	    }

	    @Bean
	    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
	        SchedulerFactoryBean factory = new SchedulerFactoryBean();
	        factory.setJobFactory(springBeanJobFactory());
	        factory.setQuartzProperties(quartzProperties());
	        return factory;
	    }

	    public Properties quartzProperties() throws IOException {
	        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
	        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
	        propertiesFactoryBean.afterPropertiesSet();
	        return propertiesFactoryBean.getObject();
	    }

	    @Bean
	    public JobDetail jobDetail() {

	        return newJob().ofType(NewsLetterJob.class).storeDurably().withIdentity(JobKey.jobKey("Qrtz_Job_Detail")).withDescription("Invoke Sample Job service...").build();
	    }

	    @Bean
	    public Trigger trigger(JobDetail job) {

	        int frequencyInSec = 10;
	        logger.info("Configuring trigger to fire every {} seconds", frequencyInSec);

	        return newTrigger().
	        		forJob(job).
	        		withIdentity(TriggerKey.triggerKey("Qrtz_Trigger")).
	        		withDescription("Newsletter trigger").
	        		withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 ? * 1,3,6")).build();
	    }
	
}
