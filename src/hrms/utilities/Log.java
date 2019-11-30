package hrms.utilities;

import org.apache.log4j.Logger;

public class Log {
	private static Logger Log = Logger.getLogger(Log.class.getName());
	public static void info(String message) {
		Log.info(message);
	}
	
	public static void debug(String Dmessage){
		Log.debug(Dmessage);
	}
	
	public static void error(String Emessage) {
		Log.error(Emessage);
	}
}
