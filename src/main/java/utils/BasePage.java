package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BasePage {

   protected static WebDriver driver;

    // Constructor to initialize the WebDriver
  
    public BasePage() {
 
        BasePage.driver = getDriver();
    }

    // Method to take a screenshot
    public void takeScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to quit the WebDriver
    @AfterClass
    public void quitDriver() {
    	System.out.println("Quit me aya...");
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Quit kiya...");
        }
    }
    
    @BeforeClass
    public static void setUp() {
        String chromedriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Getter method for WebDriver
  
    public static WebDriver getDriver() {
    	
    	System.out.println("Driver called...");
    	if (driver == null) {
    		
            initializeDriver();
        }
        return driver;
    }

    // Method to initialize WebDriver
    public static void initializeDriver() {
        String chromedriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
    }
}
