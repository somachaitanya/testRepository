package hrms.testscripts;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import hrms.common.methods.*;

public class TC001_loginPagErr {
	@Test(groups="green")
	public void login() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		General obj = new General();
		obj.browser();
		obj.openAPP();
		//obj.alert_login();
		obj.login();
		//obj.errMsg();
		obj.robot_logout();
		obj.closeAPP();
}
}