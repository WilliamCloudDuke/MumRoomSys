package edu.mum.roomsys.rest;


	import org.springframework.beans.factory.annotation.Autowired;


	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

	import edu.mum.roomsys.domain.Request;
	import edu.mum.roomsys.service.RequestService;

	@Controller
	public class RequestServiceController {
		@Autowired
		private RequestService requestService;
		
		@RequestMapping(value= {"/rest/requests"}, method = {RequestMethod.GET})
		public @ResponseBody Iterable<Request> getRequest() {
			return requestService.findAll(0, 1);
		}

		@RequestMapping(value= {"/rest/requestsType"}, method = {RequestMethod.GET})
		public @ResponseBody Iterable<Request> getRequestType() {
			return requestService.findAll();
		}
		
		
		
	}

	
	
	
	
