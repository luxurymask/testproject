package testproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jMongo {
	//public static Logger logger = LogManager.getLogger("Log4jMongo.class");
	public static void test(Log4jMongo l){
		System.out.println(l);
		l = null;
		System.out.println(l);
	}
	
	public static void main(String[] args){
		Log4jMongo l1 = new Log4jMongo();
		Log4jMongo l2 = l1;
		test(l1);
		System.out.println(l1);
		System.out.println(l2);
//		logger.trace("trace");
//		logger.debug("debug");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
//		logger.fatal("fatal");
		
	}
}
