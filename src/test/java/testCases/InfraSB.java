package testCases;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

import baseSource.BaseClass;
import components.ApprovalComponent;
import components.LoginPageComponent;
import components.SelectCatalogComponent;
import components.ServerBuildTicket;
import components.SubtaskHandlingComponent;


public class InfraSB extends BaseClass{

	public ResourceBundle rb = ResourceBundle.getBundle("SBFieldvaluedata");
	
		@Test	
		public void accIdCatalog() throws InterruptedException {
			
		LoginPageComponent loginPage = new LoginPageComponent();
		
		loginPage.goTo();
		loginPage.loginSBApplication();
		
	
		SelectCatalogComponent catalog = new SelectCatalogComponent();
		catalog.serviceDeskPortal();
		windowHandle();
		catalog.infraCatalog();
		
		ServerBuildTicket ServerBuild = new ServerBuildTicket();
		ServerBuild.formSubmission();
		ITView();
		windowHandle();
		
		Thread.sleep(20000);
		driver.navigate().refresh();
		moduleTicketData();
		sideArrow();
		ApprovalComponent approval = new ApprovalComponent();
		SubtaskHandlingComponent subtask = new SubtaskHandlingComponent();
		int approvalLevels = 2;		//mention about approval levels
		for(int i=1;i<=approvalLevels;i++) {
		String approver = statusUpdate(i);
		if("USER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("userapprover"));
			Thread.sleep(60000);
			driver.navigate().refresh();
		}
		else if("MANAGER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("managername"));
			Thread.sleep(60000);
			driver.navigate().refresh();
		}
		
		
		//driver.get("https://jiraet-sandbox.cotiviti.com/browse/IT-1346903");
		//Thread.sleep(3000);
		//sideArrow();
		//SubtaskHandlingComponent subtask = new SubtaskHandlingComponent();
		subtask.selectSubtask();
		}
		}
}