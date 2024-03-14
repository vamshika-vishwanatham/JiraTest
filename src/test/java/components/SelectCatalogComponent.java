package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;


public class SelectCatalogComponent extends BaseClass {



	@FindBy(linkText="ServiceDesk Portal")
	WebElement serviceDeskPortal;
	@FindBy(xpath="//div[@class ='rw_request_type_group_sidebar']/div/ul/li[2]")
	WebElement serviceRequestlist;
	@FindBy(xpath="//img[@alt='Application & Account Services']")
	WebElement accIdCatalog;
	@FindBy(xpath="//img[@alt='Infrastructure Services']") 
	WebElement infraCatalog;
	String frame = "rw_iframe";
	
	//By cat = By.xpath("//img[@alt='Application & Account Services']"); //Infrastructure Services
	@FindBy (xpath="//div[@class='rw_cell']/div")
	WebElement itProject;

	public void serviceDeskPortal() {
		serviceDeskPortal.click();
	}
	
	public void accIdCatalog() throws InterruptedException {
		
		accIdCatalog.click();
		Thread.sleep(3000);
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		System.out.println("************** Opened Account & Id Module **************");
		
	}
	
public void infraCatalog() throws InterruptedException {
		
		infraCatalog.click();
		Thread.sleep(3000);
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		System.out.println("************** Opened InfraStructure Module **************");
		
	}
}
