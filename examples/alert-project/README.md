This project demonstrates how to configure alerting and includes a JUnit test to show that alerting is working properly.

To try it out, first deploy the project:

    ./gradlew -i mlDeploy

And then you can run the test:

    ./gradlew test

The test does not have any assertions; rather, because the alert action simply logs some text, check MarkLogic's
`TaskServer_ErrorLog.txt` file to verify that the action logged some text. 
