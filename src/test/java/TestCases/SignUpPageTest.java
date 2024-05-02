package TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BasePage;
import java.util.Random;
import java.util.UUID;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class SignUpPageTest {

    private WebDriver driver;
    private BasePage basePage;

    @SuppressWarnings("unchecked")
    @BeforeSuite
    public void setUp() {
        driver = BasePage.getDriver();
        driver.manage().window().maximize();
    }
    private String generateRandomName() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8);
    }
    @Test(priority = 1, groups = {"signup"})
    public void verifyButtonPresent() throws InterruptedException {
        driver.get("http://43.204.112.21:8080/");
        Thread.sleep(3000);
        WebElement signUpLink = driver.findElement(By.xpath("//h4[contains(text(),'Sign Up')]"));
        signUpLink.click();

        List<WebElement> cancelButtons = driver.findElements(By.xpath("//button[contains(text(),'Cancel')]"));
        if (!cancelButtons.isEmpty()) {
            System.out.println("Button element with text 'Cancel' is present.");
        } else {
            System.out.println("Button element with text 'Cancel' is NOT present.");
        }

        List<WebElement> signUpButtons = driver.findElements(By.xpath("//button[contains(text(),'Sign Up')]"));
        if (!signUpButtons.isEmpty()) {
            System.out.println("Button element with text 'Sign Up' is present.");
        } else {
            System.out.println("Button element with text 'Sign Up' is NOT present.");
        }

        // Assuming basePage.takeScreenshot() method is defined in the BasePage class
        // basePage.takeScreenshot("verifyButtonPresent_failure");
    }

    @Test(priority = 2, groups = {"signup"})
   public void verifySignUp() throws InterruptedException {
    	
    	String firstName = generateRandomName();
        String lastName = generateRandomName();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@email.com";
        driver.get("http://43.204.112.21:8080/");
        WebElement signUpLink = driver.findElement(By.xpath("//h4[contains(text(),'Sign Up')]"));
        signUpLink.click();

        WebElement firstNameElement  = driver.findElement(By.xpath("//input[@placeholder='Enter First Name']"));
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement  = driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']"));
        lastNameElement.sendKeys(lastName);

        WebElement emailelement = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
        emailelement.sendKeys(email);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        password.sendKeys("12345678");

        WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile']"));
        mobile.sendKeys("1122334455");

        WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        signUpBtn.click();

        Thread.sleep(5000);

        // Assuming basePage.takeScreenshot() method is defined in the BasePage class
        // basePage.takeScreenshot("verifySignUp_failure");
			
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Closing WebDriver...");
       BasePage.quitDriver();
        System.out.println("WebDriver closed.");
    }
}
