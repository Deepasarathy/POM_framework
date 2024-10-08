package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonFile.CommonTC;

public class LoginUser extends CommonTC{
	
	@FindBy(linkText = "Log in") public static WebElement signintab;
	@FindBy(name = "email") public static WebElement emailid;
	@FindBy(name = "password") public static WebElement pwd;
	@FindBy(xpath = "//button[text() = 'LOGIN']") public static WebElement loginbutton;
	@FindBy(linkText = "Work-Space") public static WebElement workspacetab;
	@FindBy(xpath = "//div[@id='toast-container']/div/button") public static WebElement dialog;
	
}
