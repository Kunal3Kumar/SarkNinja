package com.Automation.com.Automation;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class App {
WebDriver driver;

    public static void main( String[] args )
    {
    	
    }
    
    public void loginWithUserName(WebElement ele, String name,String pass) {
		driver = new ChromeDriver();
		WebElement username = driver.findElement(By.cssSelector("ele"));
		username.sendKeys(name);
		WebElement passwd = driver.findElement(By.cssSelector("ele"));
		passwd.sendKeys(pass);
	}
    
    public void slectDropDownVisbleText(WebElement ele,String value) {
    	Select s =new Select(ele);
    	s.selectByVisibleText(value);
    }
    
    public void mouseHover(WebElement ele) {
    	driver= new ChromeDriver();
    	Actions a = new Actions(driver);
    	
    	a.moveToElement(ele).build().perform();
    }
    
    public void waitForElementVisibleElement(WebElement ele,int i) {
    	driver = new ChromeDriver();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
    	wait.until(ExpectedConditions.visibilityOf(ele));
    }
    
    public void selectBootStrap(List<WebElement>list, String value) {
    	for(WebElement e: list) {
    		String s =e.getText();
    		if(s.equals(value)) {
    			e.click();
    			break;
    		}
    	}
    }
    
    public void selectDropDownIndex(WebElement ele,int num) {
    	Select s = new Select(ele);
    	s.deselectByIndex(num);
    }
    
    public void switchFram(int num) {
    	driver = new ChromeDriver();
    	driver.switchTo().frame(num) ;
    	}
    
    public void selectAlertPopUp() {
    	driver = new ChromeDriver();
    	Alert a = driver.switchTo().alert();
    	a.accept();
    }
    public void waitForElementClickable(WebElement ele,long num) {
    	driver = new ChromeDriver();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(num));
    	wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
    
    public void switchWindow(String title) {
    	driver = new ChromeDriver();
    	Set<String> allWindows =  driver.getWindowHandles();
    	for(String w : allWindows) {
    		driver.switchTo().window(w);
    		if(driver.getTitle().contains(title)) {
    			break;
    		}
    	}
    }
    
    public void clickExecutor(WebElement ele) {
    	driver = new ChromeDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	j.executeScript("arguments[0].click();",ele);
		
	}
    public void validateExpectedResult(WebElement ele , String result) {
    	driver= new ChromeDriver();
    	 WebElement heading =driver.findElement(By.cssSelector("ele"));
    	 String headingText = heading.getText();
    	 assertEquals(headingText,"result");
		
	}
}
