package edu.mum.roomsys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.roomsys.logging.ILogger;

@Aspect
@Component
public class CheckinAdvice {

	@Autowired
	private ILogger logger;

	public CheckinAdvice() {
		super();
	}

	@After("execution(* edu.mum.roomsys.controller.CheckinController.createCheckIn(..))")
	public void log(JoinPoint joinpoint) {
		logger.log("Checkin process executed: " + joinpoint.getSignature().getName());
	}

}
