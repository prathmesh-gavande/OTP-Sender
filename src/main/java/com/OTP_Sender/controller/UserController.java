package com.OTP_Sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OTP_Sender.services.OTPService;
import com.OTP_Sender.services.UserService;

@Controller
public class UserController {
	String otp;
	
    @Autowired
    private UserService userservice;
    
    @Autowired
    private OTPService otpservice;
    
    @GetMapping("/login")
    public String getlogin(Model model) {
        return "adminlogin"; 
    }
    
    @GetMapping("/loginsts")
    public String getOtp(@RequestParam("username") String Username) {
        String demo = "+91" + Username;
        otp = userservice.generateOtp(Username);
        otpservice.sendOtp(demo, otp);
        return "verification"; 
    }
    
    @GetMapping("/verification")
    public String OtpVerification(@RequestParam("otp") String user_otp) {
    	if(user_otp.equals(otp)) {
    		return "success"; 
    	}
        return "fail"; 
    }
    
}

