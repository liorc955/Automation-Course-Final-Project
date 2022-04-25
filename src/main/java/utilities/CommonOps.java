package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {


    /* ---------------------------------------------------
       Method Name: getData
       Method Description: This method extracts data from the Configuration File (DataConfig.xml)
       Method Parameters: String
       Method Return: String
       --------------------------------------------------- */
    public static String getData(String nodeName){
        DocumentBuilder dBuilder;
        Document doc = null;
        File xmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /* ---------------------------------------------------
       Method Name: initBrowser
       Method Description: This method initializes the prerequisite for web testing:
       - The browser type from the config file
       - The actions and waits for web testing
       - Call to the ManagePages.initSauceDemo() Method for Page Objects initializing
       Method Parameters: String
       Method Return: void
       --------------------------------------------------- */
    public static void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver =  initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver =  initFireFoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver =  initIEDriver();
        else{
            throw new RuntimeException("Invalid platform name");
        }
        long timeOut = Long.parseLong(getData("TimeOut"));
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,timeOut);
        driver.manage().window().maximize();
        driver.get(getData("urlWeb"));
        ManagePages.initSauceDemo();
        actions = new Actions(driver);
    }

    /* ---------------------------------------------------
       Method Name: initMobile
       Method Description: This method initializes the prerequisite for mobile testing:
       - The Appium server configuration (url, desire capabilities) from the config file
       - The actions, waits for mobile testing
       - Call to the ManagePages.initMortgage() Method for Page Objects initializing
       Method Parameters: void
       Method Return: void
       --------------------------------------------------- */
    public static void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AppiumDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium server");
            System.out.println(e);
        }
        ManagePages.initMortgage();
        touchAction = new TouchAction(mobileDriver);
        long timeOut = Long.parseLong(getData("TimeOut"));
        mobileDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,timeOut);
    }


    /* ---------------------------------------------------
      Method Name: initChromeDriver
      Method Description: This method initializes the chrome driver for web testing.
      Method Parameters: void
      Method Return: WebDriver
      --------------------------------------------------- */
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /* ---------------------------------------------------
      Method Name: initFireFoxDriver
      Method Description: This method initializes the firefox driver for web testing.
      Method Parameters: void
      Method Return: WebDriver
      --------------------------------------------------- */
    public static WebDriver initFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /* ---------------------------------------------------
      Method Name: initIEDriver
      Method Description: This method initializes the IE driver for web testing.
      Method Parameters: void
      Method Return: WebDriver
      --------------------------------------------------- */
    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /* ---------------------------------------------------
      Method Name: initAPI
      Method Description: This method initializes the prerequisite for API testing:
      - The baseURI of the RestAPI server
      - The httpRequests including authentication to the server
      Method Parameters: void
      Method Return: void
      --------------------------------------------------- */
    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"),getData("Password"));
    }

    /* ---------------------------------------------------
      Method Name: initElectron
      Method Description: This method initializes the prerequisite for electron apps testing:
      - The Electron Driver and Desire Capabilities from the config file
      - The actions, waits for electron apps testing
      - Call to the ManagePages.initTodo() method for Page Objects initializing
      Method Parameters: void
      Method Return: void
      --------------------------------------------------- */
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(System.getProperty("user.home") + getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        long timeOut = Long.parseLong(getData("TimeOut"));
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,timeOut);
        actions = new Actions(driver);
    }

    /* ---------------------------------------------------
      Method Name: initDesktop
      Method Description: This method initializes the prerequisite for desktop apps testing:
      - The WinAppDriverServer from the config file
      - The waits for desktop apps testing
      - Call to the ManagePages.initCalculator() method for Page Objects initializing
      Method Parameters: void
      Method Return: void
      --------------------------------------------------- */
    public static void initDesktop(){
        dc.setCapability("app",getData("DesktopApp"));
        try {
            driver = new WindowsDriver(new URL(getData("WinAppDriverServer")),dc);
        } catch (Exception e) {
            System.out.println("Can not connect to WinAppDriver Server");
            System.out.println(e);
        }
        long timeOut = Long.parseLong(getData("TimeOut"));
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,timeOut);
        ManagePages.initCalculator();
    }

    /* ---------------------------------------------------
          Method Name: beforeClass
          Method Description: This method initializes the prerequisite for the testing session:
          - The platform testing type: web, mobile, api, electron and desktop
          - The soft assertion object for testng assertions and screen object for recording tests
          - Call to ManageDB.openConnection() method to connect to the DB for testing with DB data
          Method Parameters: String PlatformName, String DDTFile, String EnableDB - from testng xml files
          Method Return: void
          --------------------------------------------------- */
    @BeforeClass
    @Parameters({ "PlatformName", "DDTFile", "EnableDB" })
    public void beforeClass(String PlatformName,@Optional("DDTFile") String DDTFile,@Optional("EnableDB") String EnableDB) {
        platform = PlatformName;
        ddtFilePath = DDTFile;
        usingDB = Boolean.parseBoolean(EnableDB);
        if (PlatformName.equalsIgnoreCase("web")) initBrowser(getData("BrowserName"));
        else if (PlatformName.equalsIgnoreCase("mobile")) initMobile();
        else if (PlatformName.equalsIgnoreCase("api")) initAPI();
        else if (PlatformName.equalsIgnoreCase("electron")) initElectron();
        else if (PlatformName.equalsIgnoreCase("desktop")) initDesktop();
        else throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        if (usingDB)
        ManageDB.openConnection(getData("dbUrl"),getData("dbUsername"),getData("dbPassword"));
    }


    /* ---------------------------------------------------
         Method Name: afterClass
         Method Description: This method executes the following procedures after all the test cases finish running:
         - Close the web/mobile driver.
         - Close the connection to the DB server.
         Method Parameters: void
         Method Return: void
         --------------------------------------------------- */
    @AfterClass
    public void afterClass(){
        if(!platform.equalsIgnoreCase("api")){
            if (!platform.equalsIgnoreCase("mobile")) driver.quit();
            else mobileDriver.quit();
        }
        if (usingDB)
        ManageDB.closeConnection();
    }

    /* ---------------------------------------------------
         Method Name: beforeMethod
         Method Description: This method initializes the prerequisite for each test case:
         - The params JSONObject to empty the JSON payload for post/put HTTPS requests
         - Call to the MonteScreenRecorder.startRecord(method.getName()) for starting the test recording
         Method Parameters: Method - for getting the Method name
         Method Return: void
         --------------------------------------------------- */
    @BeforeMethod
    public void beforeMethod(Method method){
        if(platform.equalsIgnoreCase("api")){
            params = new JSONObject();
        } else {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* ---------------------------------------------------
        Method Name: afterMethod
        Method Description: This method navigated to the URL after the finish of each web test
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    @AfterMethod
    public void afterMethod(){
        if (platform.equalsIgnoreCase("web")) driver.get(getData("urlWeb"));
    }

}
