package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//
	
	@FindBy(xpath = "//input[@name='firstname' and @id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastname' and @id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email' and @id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password' and @id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String Fname) {
		txtFirstName.sendKeys(Fname);
	}
	
	public void setLastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}
	
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickAgree() {
		checkBox.click();;
	}
	
	public void clickContinue() {
		clickContinue.click();;
	}
	
	public String getConfimationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

}
