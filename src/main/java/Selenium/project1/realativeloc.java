package Selenium.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.concurrent.TimeUnit;

public class realativeloc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubm

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement list = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(list)).getText());
//		list.click();
//		Thread.sleep(4000);
		// System.out.println(driver.findElement(with(By.tagName("div")).below(list)).getText());
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		Thread.sleep(4000);
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		WebElement radio =driver.findElement(By.cssSelector("input[id='inlineRadio1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());

	}

}
