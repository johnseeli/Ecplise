package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
	
		driver.quit();
	}
	
	@Test
	public void verifyAccountRegistarionPage() {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName("Joe");
		regPage.setLastName("Gage");
		regPage.setEmail("abc@abc.com");
		regPage.setPassword("pass123");
		regPage.clickAgree();
		regPage.clickContinue();
		
		String conMsg = regPage.getConfimationMsg();
		Assert.assertEquals(conMsg, "Your Account Has Been Created");
	}
	
	public String randomString() {
		
	}
	
	
	
}
