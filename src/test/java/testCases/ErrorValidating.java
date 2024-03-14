package testCases;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.LoginPageComponent;
import baseSource.BaseClass;

public class ErrorValidating extends BaseClass {

	public ResourceBundle rb = ResourceBundle.getBundle("Fieldvaluedata");
	
	@Test	
	public void errorTest() throws InterruptedException {
		
	LoginPageComponent loginPage = new LoginPageComponent();
	
	loginPage.goTo();
	loginPage.loginApplication();
	Assert.assertEquals("Unable to sign in", loginPage.loginErrorMessage());
	//loginPage.otpVerification();
	
	}
}
