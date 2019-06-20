package demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class UITest {

	@Test
	public void test_firefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.apple.com");
		assertEquals(driver.getTitle(), "Apple");
		driver.close();
	}

	@Test
	public void test_chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.apple.com");
		assertEquals(driver.getTitle(), "Apple");
		driver.close();
	}

	/**
	 * set same Security level in all zones. To do that follow the steps
	 * below:
	 * 
	 * Open IE Go to Tools -> Internet Options -> Security Set all zones
	 * (Internet, Local intranet, Trusted sites, Restricted sites) to the
	 * same protected mode, enabled or disabled should not matter. Finally,
	 * set Zoom level to 100% by right clicking on the gear located at the
	 * top right corner and enabling the status-bar. Default zoom level is
	 * now displayed at the lower right.
	 */
	@Test
	public void test_ie() {		
		System.setProperty("webdriver.ie.driver", "C:\\temp\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.apple.com");
		assertEquals(driver.getTitle(), "Apple");
		driver.close();
	}

}
