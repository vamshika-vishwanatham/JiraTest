package components;

import java.util.ResourceBundle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class LoginPageComponent extends BaseClass {


	public ResourceBundle rb=ResourceBundle.getBundle("SBLogin");
	
	@FindBy(xpath="//input[@id = 'login-form-username']")
	WebElement emailId;
	@FindBy(xpath="//input[@id='login-form-password']")
	WebElement password;
	@FindBy(xpath="//input[@name='credentials.passcode']")
	WebElement passcode;
	@FindBy(xpath="//label[@for='input43']")
	WebElement keepMeSignedin;
	@FindBy(xpath="//div[@id='rememberme']/label") //login-form-remember-me
	WebElement rememberMyLogin;
	@FindBy(xpath="//div[@class='buttons']/input")
	WebElement signIn;
	@FindBy(xpath="//input[@value='Receive a code via SMS']")
	WebElement codeViaSMS;
	@FindBy(name="credentials.passcode")
	WebElement enterCode;
	@FindBy(xpath="//input[@value='Verify']")
	WebElement verify; 
	@FindBy(xpath="//div[@role='alert']/p")
	WebElement errorMessage;
	@FindBy(xpath="//div[@class='checkbox']/label/a")
	WebElement termsConditions;
	@FindBy(xpath="//button[@class='close terms-btn accept']")
	WebElement Accept;
	@FindBy(id="login-form-submit")
	WebElement login;
	
	public void goTo() throws InterruptedException {
		
		driver.get(rb.getString("url"));
		Thread.sleep(2000);
	}
	
	public void loginApplication() throws InterruptedException {
		
		emailId.sendKeys(rb.getString("email"));
		password.sendKeys(rb.getString("password"));
		Thread.sleep(2000);
		rememberMyLogin.click();
		signIn.click();
		Thread.sleep(5000);
		//codeViaSMS.click();
		
	}
	
public void loginSBApplication() throws InterruptedException {
		
		emailId.sendKeys(rb.getString("email"));
		password.sendKeys(rb.getString("password"));
		Thread.sleep(2000);
		termsConditions.click();
		Accept.click();
		login.click();
		Thread.sleep(5000);
		//codeViaSMS.click();
		
	}
	
	public void otpVerification() throws InterruptedException {
		
		enterCode.click();
		Thread.sleep(10000);
		verify.click();
		System.out.println("**************logged in**************");
		
		
	}


	public String loginErrorMessage() throws InterruptedException {
		Thread.sleep(5000);
		return errorMessage.getText();
		
		}
}
