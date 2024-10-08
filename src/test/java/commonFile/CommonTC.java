package commonFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import helperFile.DriverInstance;
import pages.LoginUser;

public class CommonTC extends DriverInstance{
	
	//public String url="https://letcode.in/";
	public static WebDriver driver ; 
	public static WebDriverWait wait;
	
	public static Properties properties=null;
	
	//LoginUser lu=new LoginUser()
	//Logger logger = (Logger) LogManager.getLogger(CommonTC.class);
	public Properties loadPropertyFile() throws IOException
	{
		FileInputStream fileIO = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileIO);
		return properties;
		
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException, InterruptedException
	{
		//PropertyConfigurator.configure(log4j.properties);
		loadPropertyFile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		
		if(browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("Firefox")) 
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, LoginUser.class);
		LoginUser.signintab.click();
		LoginUser.emailid.sendKeys(properties.getProperty("username"));
		LoginUser.pwd.sendKeys(properties.getProperty("password"));
		LoginUser.loginbutton.click();
		Thread.sleep(2000);
		boolean dialogdisplayed= LoginUser.dialog.isDisplayed();
		if(dialogdisplayed=true)
			LoginUser.dialog.click();
	}
	
	@BeforeMethod
	public void loginandClickonWorkspace() throws InterruptedException
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(LoginUser.workspacetab));
		LoginUser.workspacetab.click();
	}
}
