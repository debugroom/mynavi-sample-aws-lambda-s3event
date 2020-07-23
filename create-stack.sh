#!/usr/bin/env bash

stack_name="mynavi-sample-lambda-s3event-s3"
#stack_name="mynavi-sample-lambda-s3event-lambda"
#stack_name="mynavi-sample-lambda-s3event-sqs"
#stack_name="mynavi-sample-lambda-s3event-dynamodb"
template_path="src/main/cloudformation/s3-trigger-cfn.yml"
#template_path="src/main/cloudformation/lambda-cfn.yml"
#template_path="src/main/cloudformation/sqs-cfn.yml"
#template_path="src/main/cloudformation/dynamodb-cfn.yml"
#parameters="EnvType=Staging"

if [ "$parameters" == "" ]; then
    aws cloudformation deploy --stack-name ${stack_name} --template-file ${template_path} --capabilities CAPABILITY_IAM
else
    aws cloudformation deploy --stack-name ${stack_name} --template-file ${template_path} --parameter-overrides ${parameters} --capabilities CAPABILITY_IAM
fi