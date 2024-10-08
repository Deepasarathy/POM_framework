package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import commonFile.CommonTC;
import helperFile.DriverInstance;

public class ButtonHandle extends CommonTC
{
	
	@FindBy(linkText = "Click") public static WebElement buttonmenu;
	@FindBy(xpath = "//button[@id='home']") public static WebElement homebutton;
	@FindBy(xpath = "//button[@id='position']") public static WebElement coordinates;
	@FindBy(xpath = "//button[@id='color']") public static WebElement color;
	@FindBy(xpath = "//button[@id='property']") public static WebElement heighWeigh;
	@FindBy(xpath = "//button[@title='Disabled button']") public static WebElement buttondisable;
	@FindBy(xpath = "//div[@class='card-content']/div[6]/div/button") public static WebElement clickhold;
	@FindBy(xpath = "(//button[@id='isDisabled'])[2]/div/h2") public static WebElement clickholdText;
	
	
}
