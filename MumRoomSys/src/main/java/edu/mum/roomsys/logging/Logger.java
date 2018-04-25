package edu.mum.roomsys.logging;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {

	@Override
	public void log(String logMessage) {
		java.util.logging.Logger.getLogger("RoomSysLogger").info(logMessage);
	}

}
