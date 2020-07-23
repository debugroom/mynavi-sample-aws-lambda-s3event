package org.debugroom.mynavi.sample.aws.lambda.s3event.domain.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.model.UploadFile;

@EnableScan
public interface UploadFileRepository extends CrudRepository<UploadFile, String> {
}
