#!/usr/bin/env bash

#stack_name="mynavi-sample-lambda-s3event-s3"
stack_name="mynavi-sample-lambda-s3event-lambda"
#stack_name="mynavi-sample-lambda-s3event-sqs"
#stack_name="mynavi-sample-lambda-s3event-dynamodb"

aws cloudformation delete-stack --stack-name ${stack_name}