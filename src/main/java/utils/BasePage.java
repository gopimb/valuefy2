package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class BasePage {

  private static WebDriver driver;

    // Visible constructor
    public BasePage() {
        initializeDriver();
    }

    @BeforeSuite
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        String chromedriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
    }

    public void takeScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @AfterSuite
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
