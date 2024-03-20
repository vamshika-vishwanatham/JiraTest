package testCases;
import java.util.ResourceBundle;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import components.ApprovalComponent;
import components.LoginPageComponent;
import components.SelectCatalogComponent;
import components.SubtaskHandlingComponent;
import components.TicketCreationComponent;
import baseSource.BaseClass;


public class AccoundIDSB extends BaseClass{



	public ResourceBundle rb = ResourceBundle.getBundle("SBFieldvaluedata");
	
		@Test	
		public void accIdCatalog() throws InterruptedException {
			
		LoginPageComponent loginPage = new LoginPageComponent();
		
		loginPage.goTo();
		loginPage.loginSBApplication();
		
		SelectCatalogComponent catalog = new SelectCatalogComponent();
		catalog.serviceDeskPortal();
		windowHandle();
		catalog.accIdCatalog();
		}
		
		@Test
		public void ticketSubmit() throws InterruptedException {
		
		TicketCreationComponent ticketCreation = new TicketCreationComponent();
		ticketCreation.formSubmittion();
		
		ITView();
		windowHandle();
		
		Thread.sleep(40000);
		driver.navigate().refresh();
		sideArrow();
		moduleTicketData();
		
		}
		
		@Test(dependsOnMethods={"ticketSubmit"})
		public void approved() throws InterruptedException {
		ApprovalComponent approval = new ApprovalComponent();
		int approvalLevels = 1;		//mention about approval levels
		for(int i=1;i<=approvalLevels;i++) {
		String approver = statusUpdate(i);
		System.out.println(approver);
		if("USER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("approvername"));
		}
		else if("MANAGER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("managername"));
		}
		}
		}
		
		@AfterTest
		public void subtaskclosure() throws InterruptedException {
		SubtaskHandlingComponent subtask = new SubtaskHandlingComponent();
		subtask.selectSubtask();
		
		}
		
		}
