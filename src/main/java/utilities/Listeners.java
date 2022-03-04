package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Listeners extends CommonOps implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---------Staring Test: " + result.getName() + " ------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("---------Test:" + result.getName() + " Finished------");
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete the test file recording (Which no necessarily when the test succeeded)
            File file = new File("./test-recordings/" + result.getName() + ".avi");
            if (file.delete()){ System.out.println("File deleted successfully"); } else { System.out.println("Failed to delete the file"); }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("---------Test:" + result.getName() + " Failed------");
        if (!platform.equalsIgnoreCase("api")) {
            AllureScreenshot();
            if (result.getName().contains("visualization")){ // Attach the image of the comparing visual testing to the allure report
                attachSikuliCompareImage(System.getProperty("user.dir") + getData("ImageRepo") + result.getName() + ".png");
            }
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("---------Skipping Test: " + result.getName() + " ------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {
        System.out.println("---------Staring Execution------");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------Ending Execution------");
    }

    /* ---------------------------------------------------
        Method Name: AllureScreenshot
        Method Description: This method takes a screenshot and attaches it to the allure reports.
        Method Parameters: void
        Method Return: byte[]
        --------------------------------------------------- */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] AllureScreenshot() {
        if (!(platform.equalsIgnoreCase("mobile")))
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }

    /* ---------------------------------------------------
        Method Name: attachSikuliCompareImage
        Method Description: This method takes the compared image for visual testing and attaches it to the allure reports.
        Method Parameters: String path
        Method Return: byte[]
        --------------------------------------------------- */
    @Attachment(value = "Sikuli Compare Image", type = "image/png")
    public static byte[] attachSikuliCompareImage(String path) {
        File file = new File(path);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] image = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, "png", bos);
            image = bos.toByteArray();
        } catch (Exception e) { }


        return image != null ? image : null;
    }
}
