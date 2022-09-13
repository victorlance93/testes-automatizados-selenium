package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloWordSelenium {

	@Test 
	public void hello() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.whitelistedIps", "");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/leiloes");
		driver.quit();
		
	}
};
