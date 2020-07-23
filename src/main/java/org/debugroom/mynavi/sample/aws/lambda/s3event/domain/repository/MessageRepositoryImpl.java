package org.debugroom.mynavi.sample.aws.lambda.s3event.domain.repository;

import org.debugroom.mynavi.sample.aws.lambda.s3event.app.SQSInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageRepositoryImpl implements MessageRepository{

    @Autowired
    SQSInfo sqsInfo;

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Override
    public void save(String message) {
        queueMessagingTemplate.convertAndSend(sqsInfo.getQueueName(), message);
    }

}
