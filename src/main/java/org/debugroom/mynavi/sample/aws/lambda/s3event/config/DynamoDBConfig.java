package org.debugroom.mynavi.sample.aws.lambda.s3event.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.debugroom.mynavi.sample.aws.lambda.s3event.app.CloudFormationStackResolver;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(
        basePackages = "org.debugroom.mynavi.sample.aws.lambda.s3event.domain.repository"
)
public class DynamoDBConfig {

    private static final String DYNAMODB_ENDPOINT_EXPORT = "MynaviSampleLambdaS3Event-DynamoDB-ServiceEndpoint";
    private static final String DYNAMODB_REGION_EXPORT = "MynaviSampleLambdaS3Event-DynamoDB-Region";

    @Autowired
    CloudFormationStackResolver cloudFormationStackResolver;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                cloudFormationStackResolver.getExportValue(DYNAMODB_ENDPOINT_EXPORT),
                                cloudFormationStackResolver.getExportValue(DYNAMODB_REGION_EXPORT)
                        )
                ).build();
    }

}
