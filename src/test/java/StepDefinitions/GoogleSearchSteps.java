package StepDefinitions;

import io.cucumber.java.en.Given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("Starting - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		
		System.out.println("Project Path is :" +projectPath);
		
		System.getProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		
		System.out.println("Starting - browser is close");
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.navigate().to("https://google.com");
	}
	
	@Then("user click to accept the cookies")
	public void user_click_to_accept_the_cookies() {
		driver.findElement(By.id("L2AGLb")).click();
	}

	@When("user enters a text in google search box")
	public void user_enters_a_text_in_google_search_box() {
		driver.findElement(By.name("q")).sendKeys("Clement Chenet");
	}

	@And("hits Enter")
	public void hits_enter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to the Search Results page")
	public void user_is_navigated_to_the_search_results_page() {
		driver.getPageSource().contains("clementchenet.com");
		driver.close();
		driver.quit();
	}
}
