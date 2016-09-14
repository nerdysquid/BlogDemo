package cucumberselenuim.cucumberseleniumexample.googlesearch;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;

public class GoogleSearch{
	
	 private String chromeDriverPath = "deps//chromedriver_mac32//chromedriver";

		public static WebDriver driver;

		@Given("^User is on Google Search Page$")
		public void user_is_on_Google_Page() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			// chmod this to make this executable -> chmod +x file
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://google.com");
		}
		
		@Given("^User enters search text$")
		public void user_enters_search_text() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			driver.findElement(By.name("q")).sendKeys("infostretch.com");
			driver.findElement(By.tagName("form")).submit();
		}
		
		@Given("^Search List is displayed$")
		public void search_list_displayed() throws Throwable {
			Assert.assertTrue(driver.getCurrentUrl().endsWith("infostretch.com"));
		}
		
		@Given("^user selects the infostretch site$")
		public void user_select_infostretch_site() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			driver.findElement(By.className("g")).findElement(By.tagName("a")).click();
			
		}
		
		@Given("^user is navigated to infostretch home page$")
		public void user_navigated_to_infostretch_home() throws Throwable {
			Assert.assertTrue(driver.getCurrentUrl().contains("infostretch.com"));
		}
	
}