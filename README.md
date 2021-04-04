# Bunnings
Overview of the framework created. 
* Selenium webdriver is used to create the framework.
* Maven is used to list all the dependencies
* TesNG Framework is used to run the Test scripts
* TestNG parameters are used to do cross browser testing. 
* The TestNG file created in this project runs the tests on Chrome and Forefox as an example
* POM is used in this framwork.
* All the text/labels expected values that needs to be verified are stored in src/main/java com.bunnings.accelarators.ConstantDetails.java
* A custom log is created for every run using Log4j. It uses the dymanic text provided from text scripts and throught the validation methods used to create a readable log for failures. The logs are created in logs folder in the root. And example is added as log-1617451510443.log in logs folder 
* Screenshots of the failures are also taken by the scripts and are stored screeshots folder. An example is added in screenshot folder.
* To run the test, Required JDK, JRE, selenium and other jar files are needed. 
* The test is run from TestNG files provided
* BDD test cases are attached as "Bunnings Test Cases.xlsx"

