package com.OTP_Sender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OTP_Sender.configuration.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class OTPService {
	@Autowired
	TwilioConfiguration twilioconfig;
	
	public void sendOtp(String mobileNo,String otp) {
		try {
			
			Message.creator(new PhoneNumber(mobileNo), new PhoneNumber(twilioconfig.getContactNo()) , "Your OTP is "+otp).create();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
