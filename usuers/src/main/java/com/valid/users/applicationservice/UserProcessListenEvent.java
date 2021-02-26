package com.valid.users.applicationservice;

import com.valid.users.domain.UserProccesEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserProcessListenEvent implements ApplicationListener<UserProccesEvent> {

    private Logger logger = LoggerFactory.getLogger(UserProcessListenEvent.class);

    private UserProcess userProcess;

    public UserProcessListenEvent(UserProcess userProcess) {
        this.userProcess = userProcess;
    }

    @Override
    public void onApplicationEvent(UserProccesEvent event) {
        logger.info("Listener User Procces message: {}", event.getMessage());
        userProcess.userProcess(event.getIdUsers());
    }

}
