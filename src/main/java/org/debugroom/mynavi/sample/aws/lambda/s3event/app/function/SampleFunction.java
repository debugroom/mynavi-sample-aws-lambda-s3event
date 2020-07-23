package org.debugroom.mynavi.sample.aws.lambda.s3event.app.function;

import java.util.function.Function;
import reactor.core.publisher.Flux;

import com.amazonaws.services.s3.event.S3EventNotification;
import org.springframework.beans.factory.annotation.Autowired;

import org.debugroom.mynavi.sample.aws.lambda.s3event.app.moodel.UploadFileMapper;
import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.service.SampleService;

public class SampleFunction implements
        Function<Flux<S3EventNotification>, Flux<String>> {

    @Autowired
    SampleService sampleService;

    @Override
    public Flux<String> apply(Flux<S3EventNotification> s3EventNotificationFlux) {

        s3EventNotificationFlux.subscribe(s ->{
            if(0 != s.getRecords().size()){
                sampleService.uploadPostProcess(
                        UploadFileMapper.map(s.getRecords().get(0)));
            }
        });
        return Flux.just("Complete!");
    }

}
