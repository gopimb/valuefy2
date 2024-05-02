package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BasePage;

public class LogoutTest {

    private WebDriver driver;
    private BasePage basePage;


//    @BeforeClass
//    public void setUp() {
//     //   driver = BasePage.getDriver();
//        driver.manage().window().maximize();
//      
//    }


    @Test(priority = 1, groups = {"logout"})
    public void verifyUserLogout() throws InterruptedException {
        driver.get("http://43.204.112.21:8080/");

        WebElement loginLink = driver.findElement(By.xpath("//h4[contains(text(),'Login')]"));
        loginLink.click();

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("test131@test.com");

        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("12345678");

        Thread.sleep(3000);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();

        Thread.sleep(3000);

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        logoutBtn.click();
     //   basePage.takeScreenshot("verifyUserLogout_failure");
        Thread.sleep(5000);
    }

//    @AfterClass
//    public void tearDown() {
//        System.out.println("Closing WebDriver...");
//        basePage.quitDriver();
//        System.out.println("WebDriver closed.");
//    }
}
