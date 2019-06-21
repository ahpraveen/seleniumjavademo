package demo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Selenium - Java :UI Test
 * @author SP
 *
 */
public class ChromeTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("http://www.amazon.ca");
	}
	
	/**
	 * Test the search input
	 */

	@Test
	public void test_search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.className("nav-input")).click();
		assertTrue(driver.getCurrentUrl().contains("iphone"));
	}
	
	
	 //Thread.sleep is not a good practice;	 
	@Test
	public void test_checkHumburgerMenu(){		
		driver.findElement(By.id("nav-hamburger-menu")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String customerMenu = driver.findElement(By.id("hmenu-customer-name")).getText();
		assertEquals("Hello, Sign in", customerMenu);
	}
	
	//the implicit wait is set for the life of the WebDriver object instance.
	@Test
	public void test_hamburger_using_implicitwait(){	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("nav-hamburger-menu")).click();	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}		
		String customerMenu = driver.findElement(By.id("hmenu-customer-name")).getText();
		assertEquals("Hello, Sign in", customerMenu);
	}
	
	// Explicit wait is a intelligent wait and is recommended
	@Test
	public void test_hamburger_using_explicitWait(){	
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu")));
		ele.click();
		WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hmenu-customer-name")));
		String customerMenu = menu.getText();
		assertEquals("Hello, Sign in", customerMenu);
	}	

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
