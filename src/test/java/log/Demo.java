package log;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.core.*;


public class Demo {
	private static Logger log=LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args)
	{
		log.debug("i am debugger");
			log.info("i am informer");
		log.error("i am error");
		log.fatal("i am fatal");
	}
		}
