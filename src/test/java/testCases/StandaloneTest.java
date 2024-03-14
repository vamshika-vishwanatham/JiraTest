package testCases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jiraet-qa.cotiviti.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// login
		driver.findElement(By.xpath("//input[@id = 'input27']")).sendKeys("Vamshika.vishwanatham@cotiviti.com");
		driver.findElement(By.xpath("//input[@name='credentials.passcode']")).sendKeys("2024#Laptop");
		driver.findElement(By.xpath("//label[@for='input43']")).click();
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Receive a code via SMS']")).click();

		// otp verification
		// WebDriverWait waittime = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement passcode = driver.findElement(By.name("credentials.passcode"));
		passcode.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@value='Verify']")).click();
		System.out.println("****logged in****");

		// open portal
		driver.findElement(By.linkText("ServiceDesk Portal")).click();

		// window handle

		Set<String> windows = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows) {
			driver.switchTo().window(ServiceDeskPortal);
		}

		// open catalog
		driver.findElement(By.xpath("//div[@class='rw_request_type_group_sidebar']/div/ul/li[2]")).click();
		WebDriverWait waittime = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement catalog = waittime.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Application & Account Services']")));
		catalog.click();
		Thread.sleep(1000);
		driver.switchTo().frame("rw_iframe");
		Thread.sleep(3000);
		System.out.println("**** Opened Account & Id Module ****");

		// filling form

		driver.findElement(By.id("s2id_customfield_13223")).click(); // category
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Production Applications");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_13223:1")).click(); // subcategory
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("VA RAC");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_19907")).click(); // type of request
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Access Request");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_19396")).click(); // Access type
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("New");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_19519")).click();// Environment
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();

		driver.findElement(By.id("s2id_customfield_19510")).click(); // Is access to a shared system folder required?
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Yes");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.name("customfield_13320")).sendKeys("Testing");// Shared Folder Path

		driver.findElement(By.id("s2id_customfield_19372")).click(); // Shared Folder Access Type
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Read");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_19909")).click(); // Is access to a VA RAC Report / SQL Server //
																		// Required?
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]")).click();

		driver.findElement(By.id("customfield_19505")).sendKeys("Test ticket");// Report URL/Server Details

		driver.findElement(By.id("s2id_customfield_19517")).click(); // Is access to Jump Server required?
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Yes");
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("s2id_customfield_19910")).click(); // Is access to the VA RAC Provider Portal //
																		// Required?
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]")).click();

		driver.findElement(By.id("s2id_customfield_19380")).click(); // User Role
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();
		// Thread.sleep(2000);

		driver.findElement(By.id("customfield_18704")).sendKeys("25/Dec/23");

		driver.findElement(By.id("customfield_11543")).sendKeys("Test ticket please ignore");

		driver.switchTo().parentFrame();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='rw_item_footer']/button[2]/span")).click();

		// open ticket in IT view
		driver.findElement(By.cssSelector(".rw_request_key.rw_request_key_link")).click();

		// window handle
		Set<String> windows1 = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows1) {
			driver.switchTo().window(ServiceDeskPortal);
		}

		Thread.sleep(3000);
		// driver.get("https://jiraet-qa.cotiviti.com/browse/IT-157023");
		driver.findElement(By.xpath("//div[@class='aui-sidebar-footer']/button")).click();
		Thread.sleep(3000);

		// driver.navigate().refresh();

		String currentUrl = driver.getCurrentUrl();

		// open switch user
		driver.findElement(By.cssSelector(".aui-iconfont-appswitcher")).click();
		driver.findElement(By.xpath("//div[@id='app-switcher']/div/ul/li[5]")).click();
		Thread.sleep(3000);
		String switchUser = driver.getCurrentUrl();

		// open approver profile
		driver.findElement(By.cssSelector(".sr-rs__value-container.css-1ftf48x")).click();
		driver.findElement(By.id("react-select-2-input")).sendKeys("yamini.manne@cotiviti.com");
		Thread.sleep(2000);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.xpath("//button[@data-cy='execute-button']/span")).click();
		Thread.sleep(3000);
		driver.get(currentUrl);
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(30000);
		driver.navigate().refresh();

		driver.findElement(By.id("com.atlassian.servicedesk.approvals-plugin:approve-approval")).click();
		Thread.sleep(4000);

		driver.get(switchUser);
		driver.findElement(By.partialLinkText("Return to your session as ")).click();
		Thread.sleep(2000);
		driver.get(currentUrl);
		driver.navigate().refresh();
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(40000);
		driver.navigate().refresh();

		// Thread.sleep(5000);
		// driver.get("https://jiraet-qa.cotiviti.com/browse/IT-157030");
		// driver.findElement(By.xpath("//*[@id='sidebar']/div/div[2]/button")).click();

		// open subtask
		List<WebElement> subtaskList = driver.findElements(By.xpath("//tbody[@class='ui-sortable']/tr"));

		for (int i = 1; i <= subtaskList.size(); i++) {

			Thread.sleep(10000);
			driver.navigate().refresh();
			driver.findElement(By.xpath("//tr[" + i + "]/td[@class='issuekey']/a")).click();

			// edit issue to change assignment group
			driver.findElement(By.id("edit-issue")).click();
			WebElement assigmt = driver.findElement(By.id("customfield_11333-field"));
			assigmt.click();
			assigmt.sendKeys("TestAssignmentGroupJIRA");
			Thread.sleep(2000);
			assigmt.sendKeys(Keys.ENTER);

			WebElement Estimate = driver.findElement(By.id("customfield_17118"));
			Select EstTime = new Select(Estimate);
			EstTime.selectByIndex(2);

			driver.findElement(By.id("accxiaedit-issue-submit")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			System.out.println("***** Assignment Group Updated *****");

			// edit issue to change assignee
			driver.findElement(By.id("edit-issue")).click();
			WebElement Assignee = driver.findElement(By.id("assignee-field"));
			Assignee.click();
			Assignee.sendKeys("vamshika.vishwanatham@cotiviti.com");
			Thread.sleep(1000);
			Assignee.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			driver.findElement(By.id("accxiaedit-issue-submit")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			System.out.println("***** Assignee Updated *****");

			// open drop down for in progress
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(By.id("action_id_11")).click();
			Thread.sleep(5000);
			System.out.println("--------------------------------");
			System.out.println(" ");
			System.out.println("Ticket Status: " + driver.findElement(By.id("status-val")).getText());

			// open drop down for on hold
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.id("action_id_61")).click();

			Thread.sleep(3000);
			WebElement sub = driver.findElement(By.id("customfield_12711"));
			Select substate = new Select(sub);
			substate.selectByIndex(3);
			Thread.sleep(1000);

			driver.switchTo().frame(driver.findElement(By.xpath("//*[@title=\"Rich Text Area\"]")));
			Thread.sleep(5000);
			WebElement commentArea = driver.findElement(By.id("tinymce"));
			commentArea.sendKeys("On Hold");
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"accxiaissue-workflow-transition-submit\"]")).click();
			Thread.sleep(10000);
			System.out.println("--------------------------------");
			System.out.println(" ");
			System.out.println("Ticket Status: " + driver.findElement(By.id("status-val")).getText());

			// open drop down to close
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.id("action_id_31")).click();

			WebElement clc = driver.findElement(By.id("customfield_11648"));
			Select closecode = new Select(clc);
			Thread.sleep(2000);
			closecode.selectByIndex(3);
			Thread.sleep(2000);
			driver.findElement(By.id("customfield_11321")).sendKeys("Test ticket please ignore");
			WebElement As = driver.findElement(By.id("customfield_17119"));
			Select ActualSize = new Select(As);
			Thread.sleep(2000);
			ActualSize.selectByIndex(4);
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@title=\"Rich Text Area\"]")));
			Thread.sleep(5000);
			WebElement comments = driver.findElement(By.id("tinymce"));
			comments.sendKeys("Tested");
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
			driver.findElement(By.id("accxiaissue-workflow-transition-submit")).click();
			Thread.sleep(30000);
			driver.navigate().refresh();
			Thread.sleep(10000);
			System.out.println("--------------------------------");
			System.out.println("Ticket Status: " + driver.findElement(By.id("status-val")).getText());

			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(7000);

		}
	}

}
