package org.debugroom.mynavi.sample.aws.lambda.s3event.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.debugroom.mynavi.sample.aws.lambda.s3event.app.SQSInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.debugroom.mynavi.sample.aws.lambda.s3event.app.CloudFormationStackResolver;

@EnableSqs
@Configuration
public class SqsConfig {

    private static final String SQS_QUEUE_EXPORT = "MynaviSampleLambdaS3Event-SQS-QueueName";
    private static final String SQS_ENDPOINT_EXPORT = "MynaviSampleLambdaS3Event-SQS-ServiceEndpoint";
    private static final String SQS_REGION_EXPORT = "MynaviSampleLambdaS3Event-SQS-Region";

    @Autowired
    CloudFormationStackResolver cloudFormationStackResolver;

    @Autowired
    AmazonSQSAsync amazonSQSAsync;

    @Bean
    public SQSInfo sqsInfo(){
        return SQSInfo.builder()
                .queueName(cloudFormationStackResolver.getExportValue(SQS_QUEUE_EXPORT))
                .build();
    }

    @Bean
    public AwsClientBuilder.EndpointConfiguration endpointConfiguration(){
        return new AwsClientBuilder.EndpointConfiguration(
                cloudFormationStackResolver.getExportValue(SQS_ENDPOINT_EXPORT),
                cloudFormationStackResolver.getExportValue(SQS_REGION_EXPORT)
        );
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(){
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

}
