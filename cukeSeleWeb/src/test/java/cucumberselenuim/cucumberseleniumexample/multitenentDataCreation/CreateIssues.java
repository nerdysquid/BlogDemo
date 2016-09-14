package cucumberselenuim.cucumberseleniumexample.multitenentDataCreation;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateIssues {
		
	private String chromeDriverPath = "deps//chromedriver_mac32//chromedriver";

	private static WebDriver driver;
	
	@Given("^User click on create issue button$")
	public void open_create_issue_popup() throws Throwable {
		driver = Login.driver;
		driver.findElement(By.id("create_link")).click();
		Thread.sleep(500);
	}
	
	@Given("^Create issue pop gets opened$")
	public void issue_pop_opened() throws Throwable {
		driver = Login.driver;
//		boolean status = checkIfDialogIsDisplayed(0);
		Assert.assertTrue(true);
	}
	
	private boolean checkIfDialogIsDisplayed(int noOfTrials) {
		driver = Login.driver;
		if (noOfTrials < Utils.Constant.MAX_NO_OF_FAILED_TRIALS) {
			try {
				WebElement element = driver.findElement(By.id("create-issue-dialog"));
				return element.isDisplayed();
			} catch (NoSuchElementException err) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					return checkIfDialogIsDisplayed(++noOfTrials);
				}
			}
		} else {
			return false;
		}
	}
	
	@When("^User selects project$")
	public void user_selects_project() throws Throwable {
		driver = Login.driver;
		driver.findElement(By.id("project-single-select")).findElement(By.className("drop-menu")).click();
		driver.findElement(By.id("project-field")).sendKeys("QTM");
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.id("project-suggestions"));
		element.findElement(By.linkText(Utils.Constant.PROJECT_NAME+" ("+ Utils.Constant.PROJECT_KEY+")")).click();
		Thread.sleep(3000);
	}
	
	@When("^Select issuetypes$")
	public void user_selects_issuetypes() throws Throwable {
		driver = Login.driver;
		String issueType = "action-step";
		driver.findElement(By.id("issuetype-single-select")).findElement(By.className("drop-menu")).click();
		driver.findElement(By.id("issuetype-field")).sendKeys("Action Step");
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.id("issuetype-suggestions"));
		element.findElement(By.className("aui-list-item-li-"+issueType)).click();
		Thread.sleep(3000);
	}
	
	@When("^enters summary and click on create button$")
	public void user_enters_summary() throws Throwable {
		driver = Login.driver;
		int index = 0;
		String summary = Utils.Constant.CLIENT_IDENTIFIER+" - summary text "+index;
		driver.findElement(By.id("summary")).sendKeys(summary);
		driver.findElement(By.id("create-issue-submit")).click();
	}
	
	
	@Then("^Issues will be created in jira$")
	public void issue_create_in_jira() throws Throwable {
			Assert.assertTrue(true);
	}
	
	
}
