package org.debugroom.mynavi.sample.aws.lambda.s3event.config;

import org.debugroom.mynavi.sample.aws.lambda.s3event.app.CloudFormationStackResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = MessagingAutoConfiguration.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CloudFormationStackResolver cloudFormationStackResolver(){
        return new CloudFormationStackResolver();
    }

}
