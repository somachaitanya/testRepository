package hrms.testscripts;

import org.testng.annotations.Test;


import hrms.common.methods.General;

public class TC002_leave{
	@Test
	public void holiday() throws Exception {
		
		General gen = new General();
		gen.browser();
		gen.openAPP();
		gen.login();
		gen.leave_spHlydays();
		gen.logout();
		gen.closeAPP();
	}

}
