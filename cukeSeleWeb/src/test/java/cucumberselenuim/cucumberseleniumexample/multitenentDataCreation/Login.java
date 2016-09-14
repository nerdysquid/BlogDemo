package cucumberselenuim.cucumberseleniumexample.multitenentDataCreation;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	private String chromeDriverPath = "deps//chromedriver_mac32//chromedriver";

	public static WebDriver driver;
	
	@Given("^User is on Jira Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// chmod this to make this executable -> chmod +x file
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Utils.Constant.JIRA_INSTANCE);
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys(Utils.Constant.USER_NAME);
		driver.findElement(By.id("password")).sendKeys(Utils.Constant.PASSWORD);
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
	}
	
	@When("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		
		try{
			WebElement element = driver.findElement(By.linkText("QMetry"));
			Assert.assertTrue(element.isDisplayed());
		}catch(NoSuchElementException err){
			Assert.assertTrue(false);
		}
	}

}
