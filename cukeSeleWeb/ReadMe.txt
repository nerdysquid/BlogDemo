Steps to verify before running "mvn test":
- Depending upon your OS (Windows/Mac), please verify chromeDriverPath in src/test/java/cucumberselenium/cucumberselenium/stepDefinition/Test_Steps.java.
- Verify the apiKey, testRunName, platform, server, os_username and os_password in systemPropertyVariables in pom.xml.

Then you can run the project with "mvn test" and verify the issues created in Jira. Good luck. :)