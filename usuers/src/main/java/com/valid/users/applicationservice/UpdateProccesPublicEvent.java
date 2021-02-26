package com.valid.users.applicationservice;

import com.valid.users.domain.UserProccesEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UpdateProccesPublicEvent implements UpdatedUserProcess {

    private Logger logger = LoggerFactory.getLogger(UpdateProccesPublicEvent.class);

    private ApplicationEventPublisher applicationEventPublisher;

    public UpdateProccesPublicEvent(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void updateUserProcess(String[] listIdUsers) {
        publishCustomEvent("Update procces state user", listIdUsers);
    }

    public void publishCustomEvent(final String message, String[] listIdUsers) {
        UserProccesEvent customSpringEvent = new UserProccesEvent(this, message, listIdUsers);
        logger.info("send Event: {}", message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
