package org.debugroom.mynavi.sample.aws.lambda.s3event.domain.service;

import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.model.UploadFile;

public interface SampleService {

    public void uploadPostProcess(UploadFile uploadFile);

}
