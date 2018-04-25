package edu.mum.roomsys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;

import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.logging.ILogger;

@Aspect
@Component
public class CheckoutAdvice {

	@Autowired
	private ILogger logger;

	public CheckoutAdvice() {
		super();
	}

	@Around("execution(* edu.mum.roomsys.controller.CheckoutController.createCheckout(..)) && args (bookItemToBeAdded, model)")
	public Object checkInMonitor(ProceedingJoinPoint call, BookItem bookItemToBeAdded, Model model) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object obj = call.proceed();
		logger.log("Checkout process executed: " + call.getSignature().getName());
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		logger.log("Checkout for Student: " + bookItemToBeAdded.getBooking().getStudent().getName() + " for Building: "
				+ bookItemToBeAdded.getBooking().getRoom().getBuildNumber());
		logger.log("Time spent in Checkout process: " + totaltime + " ms");
		return obj;
	}

}
