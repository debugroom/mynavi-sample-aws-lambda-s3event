package org.debugroom.mynavi.sample.aws.lambda.s3event.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DynamoDBTable(tableName = "upload-file-table")
public class UploadFile {

    @Id
    @DynamoDBHashKey
    private String fileId;
    @DynamoDBAttribute
    private String awsRegion;
    @DynamoDBAttribute
    private String objectKey;
    @DynamoDBAttribute
    private String eventName;
    @DynamoDBAttribute
    private String eventSource;
    @DynamoDBAttribute
    private String eventVersion;
    @DynamoDBAttribute
    private String eventTime;
    @DynamoDBAttribute
    private String ipAddress;
    @DynamoDBAttribute
    private String principalId;
    @DynamoDBAttribute
    private String bucketName;
    @DynamoDBAttribute
    private String arn;
    @DynamoDBAttribute
    private String ownerIdentity;
    @DynamoDBAttribute
    private String urlDecordedKey;
    @DynamoDBAttribute
    private String size;
    @DynamoDBAttribute
    private String sequencer;
    @DynamoDBAttribute
    private String eTag;

}
