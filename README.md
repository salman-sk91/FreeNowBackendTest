# Free-Now Backend Automation Framework

A simple API automation test suite that performs validations for the comments for the post made by a
specific user named “Samantha”.

available at https://jsonplaceholder.typicode.com/


****************************************************************************

## How the Framework works?

Its a Modular Test Driven Framework, all the test scenarios use **@Test** annotation of **TestNG** in their respective Test files.<br>
The test data is stored in a separate **testConfig.properties** file.<br>
The Response can be parsed using **Json Path** and also using individual **response POJO class**.<br> 
Provided separate **DataContainer class** for individual test class file to store data used during test script execution. There is no test data dependency between test files.<br>
Easy to add a test scenario, ease of maintaining the test data and test scripts.

The framework has custom reporting for additional details on the test execution.
Having TestNg's default test reporting to view the details/results of test execution.

For any commits made to **master** branch the Automated tests are Build and run on Circle Ci <br>
Circleci url : https://app.circleci.com/pipelines/github/salman-sk91

****************************************************************************

## Flows automated as part of the project are as follows -

* Search and verify specific user named "Samantha"
* Get all Post written by user 
* Get all comments for each post and 
* Validate the correctness of Email mentioned in the comments

****************************************************************************

## Tools/Technologies used are as follows -

* RestAssured
* Java
* TestNG
* Maven
* Surefire
* JsonPath
* Apache Commons Validator
* CircleCi integration

****************************************************************************

## How to execute the Tests ?

* Clone the repository to your workspace.
* Build the project using maven
* Execute the test using testng.xml or pom.xml file directly
* OR
* Run "ExecuteTest" windows batch file
* Once the execution completes the result will be available at: {project.directory}/target/surefire-reports/index.html

****************************************************************************

## Things to improve:
* Better reporting using Extent report or Allure reports
* Having only assertions in the Test Files and all the application logic in the module file

****************************************************************************
