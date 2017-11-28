package qaconsulting.com.AutomatedTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

	private String url = "https://www.github.com/";
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@Test
	public void githubTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\AutomatedTesting\\chromedriver.exe");
		webDriver.navigate().to(url);
		WebElement login = webDriver.findElement(By.cssSelector("body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu.HeaderMenu--bright.d-lg-flex.flex-justify-between.flex-auto > div > span > div > a:nth-child(1)"));
		login.click();
		WebElement userName = webDriver.findElement(By.cssSelector("#login_field"));
		userName.sendKeys("alexhalsall653@live.com");
		
		WebElement password = webDriver.findElement(By.cssSelector("#password"));
		password.sendKeys("halsall22");
		
		WebElement signInButton = webDriver.findElement(By.cssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block"));
		signInButton.click();
		
		String returnUrl = webDriver.getCurrentUrl();
		String expectedUrl = "https://www.github.com/";
		assertEquals("Not on the right URL", expectedUrl, returnUrl);
	}
	
	

}
