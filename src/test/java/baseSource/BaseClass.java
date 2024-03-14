package baseSource;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import components.LoginPageComponent;
import components.SubtaskHandlingComponent;

public class BaseClass {

	public static WebDriver driver;
	public LoginPageComponent loginPage;
	public String statusCode;
	public SubtaskHandlingComponent subtaskhandling;
	public String statusValue;

	public BaseClass() {
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public void inizializeDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	public void ITView() {
		driver.findElement(By.cssSelector(".rw_request_key.rw_request_key_link")).click();
	}

	public void windowHandle() {

		Set<String> windows = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows) {
			driver.switchTo().window(ServiceDeskPortal);
		}
	}

	public void multiThread() throws InterruptedException {
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(40000);
		driver.navigate().refresh();
	}

	public void multiThreads() throws InterruptedException {
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(1);
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(2);
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(3);
	}

	public void elementToBeClickable(By expectedElement) {
		WebDriverWait waittime = new WebDriverWait(driver, Duration.ofSeconds(60));
		waittime.until(ExpectedConditions.elementToBeClickable(expectedElement));
	}

	public void sideArrow() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='aui-sidebar-footer']/button")).click();
		Thread.sleep(3000);

	}

	public String statusUpdate(int level) throws InterruptedException {
		Thread.sleep(2000);
		//driver.navigate().refresh();
		statusValue = driver.findElement(By.id("opsbar-transitions_more")).getText();
		System.out.println(statusValue);
		/*
		 * if (level != 1) {
		 * 
		 * String current = driver.getCurrentUrl(); //multiThread(); Thread.sleep(5000);
		 * driver.navigate().refresh(); statusValue =
		 * driver.findElement(By.id("opsbar-transitions_more")).getText();
		 * driver.findElement(By.linkText("View customer request")).click();
		 * windowHandle(); driver.navigate().refresh(); driver.get(current); }
		 */
				if ("user approval".equals(statusValue)) {//user approval
					statusCode = "USER APPROVAL";
				} else if ("Manager Approval".equals(statusValue)) {
					statusCode = "MANAGER APPROVAL";
				} else {
					statusCode = null;
				}
		//System.out.println(statusCode);
		return statusCode;
	}

	public void moduleTicketData() throws InterruptedException {
		List<WebElement> SubtaskData = driver.findElements(By.xpath("//*/div[@class = 'module toggle-wrap']"));
		for (int i = 0; i < SubtaskData.size(); i++) {
			System.out.println(SubtaskData.get(i).getText());
			System.out.println("-----------------------");
		}
		Thread.sleep(5000);
	}

}
