How to Run and Configure Project 
• To run the application clone the project and import project in any compiler such as Eclipse IDE, and click on testing.xml file at location “/SeleniumCucumberBDDFramework-Final/testng.xml” and run as TESTNG. 
• Project is using maven to download dependencies. • You need to set the Operating system and also the browser driver. 
• Change the OS and browser name in the file “/SeleniumCucumberBDDFramework-Final/resources/test-configs.properties)”. 
• Location of all drivers is at “/SeleniumCucumberBDDFramework-Final/Driver/ “ 
• To change the browser you need to go to "/SeleniumCucumberBDDFramework-Final/resources/test-configs.properties” 
• As there are 3 Scenarios, to run any specific scenario you need to provide tag value. The tag value for first scenario is "@Revoult" and for second scenario is "@Revoult2” and third is "@Revoult3”. 
• These tags can be set at file “/SeleniumCucumberBDDFramework-Final/src/com/testautomation/TestRunner/TestRunner.java”.

Implementation 
• Any framework using any programming language (CUCMBER & JAVA) 
• BDD (Cucumber) 
• POM (Implemented) 
• Can be executed on chrome, firefox. (Implemented) 
• Screenshots for each Step (Implemented) Screenshot for all Steps , can be found at location “/SeleniumCucumberBDDFramework-Final/Reports/ScreenShots”) 
• HTML report for the test run result (Extent Reporting is Implemented and report can be found at location “/SeleniumCucumberBDDFramework-Final/Reports/Extent_Report.html”.

More Information
• All Scenario’s are running successfully. 
• If any test fails please go to “/SeleniumCucumberBDDFramework-Final/Reports/Extent_Report.html” and click on the failed step. You will get the information of the reason of failure. 
• You can verify that the test is failing due to any assertion by comparing the screenshots at location “/SeleniumCucumberBDDFramework-Final/Reports/ScreenShots” 
• Project can be further integrated with continuous integration tool such as Jenkins and Bamboo.
• Logs for the test run can be found at “/SeleniumCucumberBDDFramework-Final/logs/logs.log” 
• You can also use tail –f /{your project location/“/SeleniumCucumberBDDFramework-Final/logs/logs.log”}
