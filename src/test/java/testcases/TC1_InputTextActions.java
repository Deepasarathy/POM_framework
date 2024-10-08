package testcases;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonFile.CommonTC;
import pages.ButtonHandle;
import pages.InputText;

public class TC1_InputTextActions extends CommonTC
{
	public void entertheInputText(String fname) throws InterruptedException
	{
		PageFactory.initElements(driver, InputText.class);
		InputText.inputEdit.click();
		InputText.fullname.sendKeys(fname);
		Thread.sleep(2000);
		System.out.println("FullName:"+InputText.fullname.getAttribute("value"));
	}
	
	public void enterTexttoAppend(String appnd)
	{
		InputText.appendtext.sendKeys(appnd);
		System.out.println("After appending:"+InputText.appendtext.getAttribute("value"));
	}
	
	public void getTextinside()
	{
		System.out.println("read text:"+InputText.insidetext.getAttribute("value"));
	}
	 
	public void cleartheText()
	{
		InputText.cleartext.clear();
		System.out.println("Text is Cleared");
	}
	
	public void checkFieldisDisabled()
	{
		System.out.println("Is the text field is disable?:"+InputText.disabledtext.isDisplayed());
	}
	public void checkTextReadonly()
	{
		System.out.println("is the Text field is readonly?:"+InputText.readonlytext.isEnabled());
	}
	
	
	
	@Test
	public void inputTextFunctions() throws Exception
	{
		entertheInputText("Deepa");
		enterTexttoAppend(" How about you?");
		getTextinside();
		cleartheText();
		checkFieldisDisabled();
		checkTextReadonly();
	
	}
	
	
}
