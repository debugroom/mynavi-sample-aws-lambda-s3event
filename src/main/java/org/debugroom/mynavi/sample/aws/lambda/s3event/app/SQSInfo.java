package org.debugroom.mynavi.sample.aws.lambda.s3event.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SQSInfo {

    private String queueName;

}
