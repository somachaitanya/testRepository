package hrms.common.methods;

import org.openqa.selenium.WebDriver;

public class Global {
	 WebDriver driver;
	 String url = "http://127.0.0.1/orangehrm-2.6/login.php";
	 public String un = "admin";
	 public String pw = "admin";
	 public String holydayNam = "Dussera";
	 
	 
	 public String un_nm = "txtUserName";
	 public String pw_nm = "txtPassword";
	 public String lgbtn_nm = "Submit";
	 public String err_xp = "//font[text()='Invalid Login']";
	 public String leave_xp="//span[text()='Leave']";
	 public String daysOff_xp="//span[text()='Define Days Off']";
	 public String spcHldy_lt = "Specific Holidays";
	 public String logout_lt ="Logout";
	 public String addbtn_xp="//input[@value='Add']";
	 public String holyNamtxt_id ="txtDescription";
	 public String date_xp="//input[@name='Submit']";
	 public String day_xp="//a[text()='28']";
	 public String repeatChkbox = "chkRecurring";
	 public String savebtn_id = "saveBtn";
}
