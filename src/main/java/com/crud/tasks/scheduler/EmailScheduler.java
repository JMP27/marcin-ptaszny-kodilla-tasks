package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: once a day";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    @Scheduled(fixedDelay = 10000)
    private void sendInformationEmail() {
        long size = taskRepository.count();
        if (size == 1) {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    SUBJECT,
                    "Currently in database you have got " + size + " task"
            ));
        } else {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    SUBJECT,
                    "Currently in database you have got " + size + " tasks"
            ));
        }
    }
}
