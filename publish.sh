#!/bin/bash

echo "STEP 0 (Compiling)"
mvn clean
mvn install

echo "STEP 1 (Determine WAR file path)"
warFilePath="target/mpdamexam.war"
echo $warFilePath

echo "STEP 2 (Copy WAR file as ROOT.zip)"
cp $warFilePath ROOT.zip

echo "STEP 3 (Set variables)"
username="Hamzajeljeli"
password="21545049H@mza"
sitename="m1mpdam-exam"
warZipFile="ROOT.zip"

echo "STEP 4 (POST using cURL)"
curl -X POST -u $username:$password https://$sitename.scm.azurewebsites.net/api/wardeploy --data-binary @$warZipFile
echo "STEP 5 (Delete posted file)"
rm ROOT.zip
echo "DONE"