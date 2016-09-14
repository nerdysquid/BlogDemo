package cucumberselenuim.cucumberseleniumexample.CustomerRegistrationForm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerRegistrationForm{
	
	 private String chromeDriverPath = "deps//chromedriver_mac32//chromedriver";

		public static WebDriver driver;
		public static int totalData;

		@Given("^User is on register customer Page$")
		public void user_is_on_Google_Page() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			// chmod this to make this executable -> chmod +x file
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://localhost:8080/JavaServerFaces/faces/default.xhtml");
			totalData = driver.findElements(By.className("order-table")).get(0).findElements(By.tagName("tr")).size();
		}
		
		@When("^User enters John as customer name$")
		public void user_enters_search_text() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			driver.findElement(By.id("j_idt22:name")).sendKeys("John");
		}
		
		@When("^User enters Wall Street as customer address$")
		public void search_list_displayed() throws Throwable {
			driver.findElement(By.id("j_idt22:address")).sendKeys("Wall Street");
		}
		
		@When("^submit the form$")
		public void user_select_infostretch_site() throws Throwable { 
			// Write code here that turns the phrase above into concrete actions
			driver.findElement(By.name("j_idt22:j_idt28")).click();
			
		}
		
		@Then("^form is submitted successfully$")
		public void user_navigated_to_infostretch_home() throws Throwable {
			Assert.assertTrue(driver.getCurrentUrl().contains("faces/default.xhtml"));
		}
	
}