package cucumberselenuim.cucumberseleniumexample.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	// Constants
	// For Windows
//	private String chromeDriverPath = "deps\\chromedriver_win32\\chromedriver.exe";
	// For mac
	 private String chromeDriverPath = "deps//chromedriver_mac32//chromedriver";

	public static WebDriver driver;

	@Given("^User is on Jira Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// chmod this to make this executable -> chmod +x file
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qtmserverjira.qmetry.com");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("login-form-username")).sendKeys("dhara");
		driver.findElement(By.id("login-form-password")).sendKeys("Ispl123#");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
	}

	@When("^User searches for issue$")
	public void user_searches_for_issue() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("quickSearchInput")).sendKeys("QATM-3");
		driver.findElement(By.id("quicksearch")).submit();
	}

	@Then("^Issue page gets opened$")
	public void issue_page_gets_opened() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("&&&&&&&&&&&&&&&&" + driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().endsWith("browse/QATM-3"));
	}

	@Given("^Issue page is open$")
	public void issue_page_is_open() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().endsWith("browse/QATM-3"));
	}

	@When("^User enters description$")
	public void user_enters_description() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("description-val")).click();
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("test");
	}

	@When("^User submits description$")
	public void user_submits_description() throws Throwable {
		driver.findElement(By.id("description-form")).submit();
		Thread.sleep(5000);
	}

	@Then("^description text gets updated$")
	public void description_text_gets_updated() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("&&&&&&&&&&&&&&&&" + driver.getCurrentUrl());
		Assert.assertTrue(
				driver.findElement(By.id("description-val")).findElement(By.tagName("p")).getText().equals("test"));
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("user-options")).findElement(By.id("header-details-user-fullname")).click();
		driver.findElement(By.id("log_out")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Logout Successfully");
	}
}
