package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties Locators = new Properties();
	public static Properties Credentials = new Properties();
	
	public static FileReader Loc_fr;
	public static FileReader fr;
	public static FileReader Cred;
	
	@BeforeTest
	public void setUp() throws IOException {
	
		if(driver==null) {
			
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\config.properties");
			Loc_fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\locators.properties");
			Cred = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configFile\\credentials.properties");
			
			Locators.load(Loc_fr);
			prop.load(fr);
			Credentials.load(Cred);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			BaseTest.driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.get(prop.getProperty("zohoURL"));
			
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup(); 
			 BaseTest.driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("zohoURL"));
			
			
		}
					
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		System.out.println("Tear doen successful");
		
	}

}
