package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonFile.CommonTC;
public class InputText extends CommonTC{
	
	@FindBy(linkText = "Edit") public static WebElement inputEdit;
	@FindBy(id = "fullName") public static WebElement fullname;
	@FindBy(id = "join") public static WebElement appendtext;
	@FindBy(id = "getMe") public static WebElement insidetext;
	@FindBy(id = "clearMe") public static WebElement cleartext;
	@FindBy(id = "noEdit") public static WebElement disabledtext;
	@FindBy(id = "dontwrite") public static WebElement readonlytext;

}
