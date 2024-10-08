package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonFile.CommonTC;
import pages.ButtonHandle;
import pages.LoginUser;

public class TC2_ButtonActions extends CommonTC{

	public void gotoButtonMenu()
	{
	PageFactory.initElements(driver, ButtonHandle.class);
	ButtonHandle.buttonmenu.click();
	}
	
	public void clickHomeandGoBack()
	{
	//goto home button
	ButtonHandle.homebutton.click();
	
	//goback
	driver.navigate().back();
	String actualtitle = driver.getTitle();
	System.out.println(actualtitle);
	String expectedtitle = "Interact with Button fields";
	System.out.println(expectedtitle);
	Assert.assertEquals(actualtitle, expectedtitle,"title is match");
	}
	
	public void getCoordinates()
	{
	//get the coordinates
	System.out.println("The X & Y coordinates are: "+ButtonHandle.coordinates.getLocation());
	}
	
	public void getColor()
	{
	//get the color 
	System.out.println("The color of the button is: "+ButtonHandle.color.getCssValue("background-color"));
	}
	
	public void getHeighandWeigh()
	{
	//get the height and Weight of button
	System.out.println("Button height & Weight: "+ButtonHandle.heighWeigh.getSize());
	}
	
	public void checkButtonDisabled()
	{
	//check whether the button is disabled
	boolean buttonmode = ButtonHandle.buttondisable.isEnabled();
	if(buttonmode==false)
		System.out.println("The button is disabled");
	else
		System.out.println("The button is enabled");
	}
	
	public void clickandHoldButton()
	{
	//Click and hold the button
	Actions action =  new Actions(driver);
	action.moveToElement(ButtonHandle.clickhold).clickAndHold().build();
	action.perform();
	//wait.until(ExpectedConditions.textToBePresentInElement(ButtonHandle.clickholdText, "Button has been long pressed"));
	String afterclicktext = ButtonHandle.clickholdText.getText();
	System.out.println("After Click: the text is: "+ afterclicktext);
	//Assert.assertEquals("Button has been long pressed", afterclicktext);
	}
	
	@Test
	public void ButtonFunctions()
	{
		gotoButtonMenu();
		clickHomeandGoBack();
		getCoordinates();
		getColor();
		getHeighandWeigh();
		checkButtonDisabled();
		clickandHoldButton();
	}
	
}
