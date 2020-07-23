package org.debugroom.mynavi.sample.aws.lambda.s3event.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.model.UploadFile;
import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.repository.MessageRepository;
import org.debugroom.mynavi.sample.aws.lambda.s3event.domain.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SampleServiceImpl implements SampleService{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UploadFileRepository uploadFileRepository;

    @Override
    public void uploadPostProcess(UploadFile uploadFile) {
        uploadFile.setFileId(UUID.randomUUID().toString());
        uploadFileRepository.save(uploadFile);
        try{
            messageRepository.save(objectMapper.writeValueAsString(uploadFile));
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

}
