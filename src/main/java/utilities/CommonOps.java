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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

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

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"),getData("Password"));
    }

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        long timeOut = Long.parseLong(getData("TimeOut"));
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,timeOut);
        actions = new Actions(driver);
    }

    public static void initDesktop(){
        dc.setCapability("app",getData("DesktopApp"));
        try {
            driver = new WindowsDriver(new URL(getData("WinAppDriverServer")),dc);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium server");
            System.out.println(e);
        }
        long timeOut = Long.parseLong(getData("TimeOut"));
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,timeOut);
        ManagePages.initCalculator();
    }


    @BeforeClass
    public void beforeClass() {
        if (getData("PlatformName").equalsIgnoreCase("web")) initBrowser(getData("BrowserName"));
        else if (getData("PlatformName").equalsIgnoreCase("mobile")) initMobile();
        else if (getData("PlatformName").equalsIgnoreCase("api")) initAPI();
        else if (getData("PlatformName").equalsIgnoreCase("electron")) initElectron();
        else if (getData("PlatformName").equalsIgnoreCase("desktop")) initDesktop();
        else throw new RuntimeException("Invalid platform name");
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("dbUrl"),getData("dbUsername"),getData("dbPassword"));
    }

    @AfterClass
    public void afterClass(){
        if(!getData("PlatformName").equalsIgnoreCase("api")){
            if (!getData("PlatformName").equalsIgnoreCase("mobile")) driver.close();
            else mobileDriver.close();
        }
        ManageDB.closeConnection();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        if(getData("PlatformName").equalsIgnoreCase("api")){
            params = new JSONObject();
        } else {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void afterMethod(){
        if (getData("PlatformName").equalsIgnoreCase("web")) driver.get(getData("urlWeb"));
    }

}
