
# Full Stack Test Automation Course - Final Project

This project is the final project I build during my study in a Full Stack Test Automation Course.
In this project, I build a generic automation framework that supports various platforms.



## Roadmap

 -  Web (Selenium) - Done
 -  Grapich Element Support (Sikuli) - Done
 -  Mobile (Appium) - Done
 -  REST API - Done
 -  Desktop App 
 -  Angular JS 
 -  Electron Apps - Done
 -  Database Integration
 -  CI/CD Integration


## Tech Stack

For this project, I used the following maven packages:
- [TestNG](https://testng.org/doc/) - Testing framework for Java
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) - Selenium automates browsers
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - Open-Source Java library that carries out the management of the drivers required by Selenium WebDriver
- [Allure Framework](https://docs.qameta.io/allure/) - Reporting System
- [Sikuli](http://sikulix.com/) - Graphic Element Testing
- [Monte Media Library](http://www.randelshofer.ch/monte/) - Java library for processing media data for root cause analyses.



## Attached resources
- allure-results folder - contains all the test reports.
- DDTFiles - contains the CSV file for the data-driven testing
- ImageRepository - contains all the pictures of visualization testing using Sikuli
- test-recordings - contains the test recordings that failed for root cause analyses.
- Configuration - contains an XML file that configures the browser, timeout, etc.. for the automation framework.


## Installation

You will need to install maven project:

https://maven.apache.org/install.html

You will need to install allure to see the tests report:

https://docs.qameta.io/allure/
    
## Running Tests

To run tests, run the following command

```bash
  mvn test clean
```

To see Allure tests results run

```bash
  allure serve allure-results
```

