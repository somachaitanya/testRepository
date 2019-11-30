package hrms.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Excel_data {
	WebDriver driver;
	FileInputStream file;
	String un2,pw2;
	
	@BeforeClass
	public  void openBrow()throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soma\\Downloads\\Programs\\selenium\\drivers\\chromedriver.exe");	
		driver = new ChromeDriver();
	}
	
	@Test
	public void login_excel() throws IOException {
		
		
		try {
			file = new FileInputStream("C:\\Users\\soma\\Desktop\\leavedata.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFCell cell =sheet.getRow(4).getCell(1);
		    un2=cell.getStringCellValue();
		    System.out.println(un2);
		    cell = sheet.getRow(4).getCell(2);
		    pw2 = cell.getStringCellValue();
		    System.out.println(pw2);
		    file.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
		
			driver.navigate().to("http://127.0.0.1/orangehrm-2.6/login.php");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.name("txtUserName")).sendKeys(un2);
			driver.findElement(By.name("txtPassword")).sendKeys(pw2);
			driver.findElement(By.name("Submit")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("logged in");
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("logged out");
		
	}
	@AfterClass
	public void close() {
		driver.close();
	}
}
