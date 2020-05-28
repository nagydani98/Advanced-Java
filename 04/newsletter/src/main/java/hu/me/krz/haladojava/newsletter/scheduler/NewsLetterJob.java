package hu.me.krz.haladojava.newsletter.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.me.krz.haladojava.newsletter.service.NewsletterSenderServiceImpl;
import hu.me.krz.haladojava.newsletter.service.NewsletterSenderService;

@Component
public class NewsLetterJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NewsletterSenderService senderService;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

        senderService.sendNewsletter();

        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}