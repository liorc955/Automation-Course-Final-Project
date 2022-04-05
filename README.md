
# Full Stack Test Automation Course - Final Project

This project is the final project I build during my study in a Full Stack Test Automation Course.
In this project, I build a generic automation framework that supports various platforms.



## Roadmap

 -  Web (Selenium) - Done
 -  Grapich Element Support (Sikuli) - Done
 -  Mobile (Appium) - Done
 -  REST API - Done
 -  Desktop App - Done
 -  Electron Apps - Done
 -  Database Integration - Done
 -  CI/CD Integration - Done


## Tech Stack

For this project, I used the following maven packages:
- [TestNG](https://testng.org/doc/) - Testing framework for Java
- [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) - Selenium automates browsers
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - Open-Source Java library that carries out the management of the drivers required by Selenium WebDriver
- [Allure Framework](https://docs.qameta.io/allure/) - Reporting System
- [Sikuli](http://sikulix.com/) - Graphic Element Testing
- [Monte Media Library](http://www.randelshofer.ch/monte/) - Java library for processing media data for root cause analyses.
- [Appium](https://mvnrepository.com/artifact/io.appium/java-client) - Test automation framework for use with native, hybrid and mobile web apps.
- [REST-Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured) - Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy.
- [JSoup](https://mvnrepository.com/artifact/org.jsoup/jsoup) - jsoup is a Java library for working with real-world HTML.
- [MySQL Connector/J](https://mvnrepository.com/artifact/mysql/mysql-connector-java) - For integrating MySQL DB testing.



## Attached resources
- allure-results folder - contains all the test reports.
- DDTFiles - contains the CSV file for the data-driven testing
- ImageRepository - contains all the pictures of visualization testing using Sikuli
- test-recordings - contains the test recordings that failed for root cause analyses.
- Configuration - contains an XML file that configures the browser, timeout, etc.. for the automation framework.
- Drivers - external drivers (current there is only for electron driver for electron testing)

## Installation

You will need to install the following things:

- https://maven.apache.org/install.html - for running the project
- https://docs.qameta.io/allure/ - to see allure results
- https://github.com/Microsoft/WinAppDriver/releases - for Desktop Tests
- https://appium.io/ - AppiumStudio for Mobile Tests
- https://file.io/Wjk9FjbtexlB - the app apk for Mobile Tests (need to install on the device mobile first)
- https://file.io/JCsyX4jkeNw0 - todo electron app to install for Electron Tests
    
## Running Tests

To run tests, run the following command

```bash
  mvn test -PWebTests
```
```bash
  mvn test -PDesktopTests
```
```bash
  mvn test -PElectronTests
```
```bash
  mvn test -PAPITests
```
```bash
  mvn test -PMobileTests
```

To see Allure tests results run

```bash
  allure serve allure-results
```
![alt text](https://i.ibb.co/cTjZkzF/12.png)
