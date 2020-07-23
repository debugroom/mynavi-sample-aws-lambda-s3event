#!/usr/bin/env bash

bucket_name=debugroom-mynavi-sample-lambda-s3event-for-deploy
stack_name="mynavi-sample-s3-lambda-s3event"
template_path="src/main/cloudformation/s3-deploy-lambda-cfn.yml"
s3_objectkey="mynavi-sample-aws-lambda-s3event-0.0.1-SNAPSHOT-aws.jar"

if [ "" == "`aws s3 ls | grep $bucket_name`" ]; then
    aws cloudformation deploy --stack-name ${stack_name} --template-file ${template_path} --capabilities CAPABILITY_IAM
fi

./mvnw package
aws s3 cp target/${s3_objectkey} s3://${bucket_name}/