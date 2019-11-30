package hrms.common.methods;



import java.awt.Robot;
import hrms.utilities.*;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class General extends Global {
	
	public void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma\\Downloads\\Programs\\selenium\\drivers\\chromedriver.exe");	
		driver = new ChromeDriver();
		Log.info("browser opened");
		
	}
	public void openAPP() {
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("app opened");
		
	}
	public void login() {
		driver.findElement(By.name(un_nm)).sendKeys(un);
		driver.findElement(By.name(pw_nm)).sendKeys(pw);
		driver.findElement(By.name(lgbtn_nm)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("logged in");
		Log.error("login completed");
	}
	public void errMsg() {
		if(driver.findElement(By.xpath(err_xp)).getText().equals("Invalid Log")) {
			System.out.println("error msg matched");
		}
		else {
			System.out.println("error msg not matched");
		}
	}
	
	public void alert_login() throws InterruptedException {
		driver.findElement(By.name(un_nm)).sendKeys(un);
		driver.findElement(By.name(lgbtn_nm)).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(3000);
		alt.accept();
		
	}
	public void leave_spHlydays() throws InterruptedException, IOException {
		
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(leave_xp))).build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath(daysOff_xp))).build().perform();
		driver.findElement(By.linkText(spcHldy_lt)).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.xpath(addbtn_xp)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(holyNamtxt_id)).sendKeys(holydayNam);
		driver.findElement(By.xpath(date_xp)).click();
		driver.findElement(By.xpath(day_xp)).click();
		driver.findElement(By.id(repeatChkbox)).click();
		driver.findElement(By.id(savebtn_id)).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
	}
	public void logout() {
		driver.findElement(By.linkText(logout_lt)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("logged out");
		Log.error("logged out");
	}
	
	public void robot_logout() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Reporter.log("logged out using robot class");
		Log.error("robot logged out");
	}
	
	public void closeAPP() {
		driver.quit();
	}
}
