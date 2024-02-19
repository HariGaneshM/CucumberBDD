package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.Configs;

public class BaseTest {
	
	public static WebDriver driver;
	public static String env;
	
	public void initializeDriver() {
		
		String browser = System.getProperty("browser", Configs.getProperty("browser"));
		env = System.getProperty("env", Configs.getProperty("env"));
		
		if (browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		else {
			
			System.out.println("Invalid browser value: "+browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public void goToPage(String url) {
		
		driver.get(url);
	}
	
	public void navigateToPage(String url) {
		
		driver.navigate().to(url);
	}
	
	public void closeDriver() {
		
		driver.quit();
    }
}
