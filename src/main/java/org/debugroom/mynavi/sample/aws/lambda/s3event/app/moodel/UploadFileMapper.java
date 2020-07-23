package org.debugroom.mynavi.sample.aws.lambda.s3event.app.moodel;

import com.amazonaws.services.s3.event.S3EventNotification;
import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.model.UploadFile;

public interface UploadFileMapper {

    public static UploadFile map(S3EventNotification.S3EventNotificationRecord record){
        return UploadFile.builder()
                .awsRegion(record.getAwsRegion())
                .eventName(record.getEventName())
                .eventSource(record.getEventSource())
                .eventVersion(record.getEventVersion())
                .eventTime(record.getEventTime().toString())
                .ipAddress(record.getRequestParameters().getSourceIPAddress())
                .principalId(record.getUserIdentity().getPrincipalId())
                .bucketName(record.getS3().getBucket().getName())
                .arn(record.getS3().getBucket().getArn())
                .ownerIdentity(record.getS3().getObject().getKey())
                .urlDecordedKey(record.getS3().getObject().getUrlDecodedKey())
                .size(record.getS3().getObject().getSizeAsLong().toString())
                .sequencer(record.getS3().getObject().getSequencer())
                .eTag(record.getS3().getObject().geteTag())
                .build();
    }

}
