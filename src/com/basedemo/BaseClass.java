package com.basedemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {
	
	public static WebDriver driver;
		
	public static void broswerLaunch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\Inheritance\\jar\\New folder\\version13\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void maximizeWindow()
{
	driver.manage().window().maximize();
}

	public static void getUrl( String url)
{
	driver.get(url);
}

	public static void textBox(By by,String str)
{
	driver.findElement(by).sendKeys(str);
}

	public static void click (WebElement r)
{
	r.click();
}

	public static WebElement element(By by)
{
	return driver.findElement(by);
}


	public static void wait1()
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
}


	protected void screenShot() throws IOException
{
	TakesScreenshot ss=((TakesScreenshot)driver);
	File source = ss.getScreenshotAs(OutputType.FILE);
	File destination = new File("D:\\Class\\vishnu6.jpeg");
	FileUtils.copyFile(source, destination);
}

public static void main(String[] args) throws IOException {
	
	BaseClass bb=new BaseClass();
	bb.broswerLaunch();
	bb.maximizeWindow();
	bb.getUrl("https://www.facebook.com/");
	bb.textBox(By.id("email"), "dskljfaklsj@sdois.com");
	bb.textBox(By.name("pass"),"293489kjhasfhka");
	WebElement loginbutton = bb.element(By.name("login"));
	bb.click(loginbutton);
	bb.screenShot();
	
}

}
