package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BasePage;

public class LoginPageTest extends BasePage {

    private WebDriver driver;

  //  @BeforeClass
//    public void setUp()throws MalformedURLException, IOException {
//    	System.out.println("Initializing WebDriver...");
//     //   driver = BasePage.getDriver();
//        driver.manage().window().maximize();
//       // basePage.initializeDriver(); 
//        System.out.println("WebDriver initialized.");
//    }

    @Test(priority = 1, groups = {"login"})
    public void verifySignUpLoginLink() throws InterruptedException {
        System.out.println("Executing verifySignUpLoginLink test...");
        driver.get("http://43.204.112.21:8080/");
        Thread.sleep(3000);
        WebElement loginLink = driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
        if (loginLink.isDisplayed()) {
            System.out.println("Link with text 'Login' is present.");
        } else {
            System.out.println("Link with text 'Login' is NOT present.");
        }

        WebElement signupLink = driver.findElement(By.xpath("//h4[contains(text(),'Sign Up')]"));
        if (signupLink.isDisplayed()) {
            System.out.println("Link with text 'Sign Up' is present.");
        } else {
            System.out.println("Link with text 'Sign Up' is NOT present.");
        }
        
        //basePage.takeScreenshot("verifySignUpLoginLink_failure");
    }

    @Test(priority = 2, groups = {"login"})
    public void verifyLoginButton() throws InterruptedException {
    	 System.out.println("Executing verifyLoginButton test...");
        Thread.sleep(5000);
        WebElement loginLink = driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
        loginLink.click();

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        if (loginButton.isDisplayed()) {
            System.out.println("Button element with text 'Login' is present.");
        } else {
            System.out.println("Button element with text 'Login' is NOT present.");
        }
        
     //   basePage.takeScreenshot("verifyLoginButton_failure");
    }

    @Test(priority = 3, groups = {"login"})
    public void verifyLogin() throws InterruptedException {
    	   System.out.println("Executing verifyLogin test...");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("test131@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12345678");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();
        
       // basePage.takeScreenshot("verifyLogin_failure");

        Thread.sleep(5000);
    }

//    @AfterClass
//    public void tearDown() {
//        System.out.println("Closing WebDriver...");
//        basePage.quitDriver();
//        System.out.println("WebDriver closed.");
//    }
}
