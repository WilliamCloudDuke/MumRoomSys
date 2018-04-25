package edu.mum.roomsys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

@Service
public class SmsService {

	public static final String ACCOUNT_SID = "ACbbb6db12162e5d871e003904aa250650";
	public static final String AUTH_TOKEN = "6b41a93018624efdfaf883b5d6e8eca0";
	public static final String TWILIO_NUMBER = "+15152985970";

	public void sendSMS(String toNumber, String textMessage) {
		try {
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("Body", textMessage));
			params.add(new BasicNameValuePair("To", toNumber));
			params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
			MessageFactory messageFactory = client.getAccount().getMessageFactory();
			Message message = messageFactory.create(params);
			System.out.println(message.getSid());
		} catch (TwilioRestException e) {
			System.out.println(e.getErrorMessage());
		}
	}

}
