package Selenium.project1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeMutipleWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Switching the  multiple windows or tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handle =driver.getWindowHandles();
		Iterator<String> it =handle.iterator();
		 String Parentwindow=it.next();
		 String Childwindow=it.next();
		 driver.switchTo().window(Childwindow);
		 driver.get("https://rahulshettyacademy.com/");
		String text= driver.findElement(By.xpath("//h2/a")).getText();
		System.out.println(text);
		driver.switchTo().window(Parentwindow);
		WebElement textfield =driver.findElement(By.cssSelector("input[name ='name']"));
		textfield.sendKeys(text);
		//Taking the specific the element screenshot
		File file=textfield.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("text.png"));
		//Taking the specific element height and width
		System.out.println(textfield.getRect().getDimension().getHeight());
		System.out.println(textfield.getRect().getDimension().getWidth());
		

	}

}
