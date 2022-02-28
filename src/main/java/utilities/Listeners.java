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
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File("./test-recordings/" + result.getName() + ".avi");
        if (file.delete()){ System.out.println("File deleted successfully"); } else { System.out.println("Failed to delete the file"); }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("---------Test:" + result.getName() + " Failed------");
        AllureScreenshot();
        if (result.getName().contains("visualization")){
            attachSikuliCompareImage(System.getProperty("user.dir") + getData("ImageRepo") + result.getName() + ".png");
        }
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
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

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] AllureScreenshot() {
        if (!(getData("PlatformName").equalsIgnoreCase("mobile")))
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }

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
