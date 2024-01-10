package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.dto.OtpRequest;
import com.example.dto.OtpVerificationRequest;
import com.example.dto.UserResponse;
import com.example.entity.User;
import com.example.security.JwtTokenUtil;
import com.example.service.EmailService;
import com.example.service.OTPService;
import com.example.service.RegisterService;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
	private  AuthenticationManager authenticationManager;
@Autowired
    private JwtTokenUtil jwtTokenUtil;
@Autowired
    private UserDetailsService userDetailsService;
@Autowired
    private UserService userService;
@Autowired
    private OTPService otpService;
@Autowired
   private EmailService emailService;
@Autowired
 private RegisterService registerService;
    

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                          UserDetailsService userDetailsService, OTPService otpService) {
        this.userService =  userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.otpService = otpService;
    }
    
    
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUUser(user);
        
        //registeredUser.setToken(jwtTokenUtil.generateToken(null));
        UserResponse userResponse = new UserResponse();
        userResponse.setName(registeredUser.getName());
        userResponse.setEmail(registeredUser.getEmail());
        userResponse.setAccountNumber(registeredUser.getAccount().getAccountNumber());
        userResponse.setIFSC_code(registeredUser.getAccount().getIFSC_code());
        userResponse.setBranch(registeredUser.getAccount().getBranch());
        userResponse.setAccount_type(registeredUser.getAccount().getAccount_type());
        

        return ResponseEntity.ok(userResponse);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user with the account number and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getAccountNumber(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            // Invalid credentials, return 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid account number or password");
        }

        // If authentication successful, generate JWT token
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getAccountNumber());
        System.out.println(userDetails);
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> result =  new HashMap<>();
        result.put("token", token);
        // Return the JWT token in the response
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    
    
    @PostMapping("/generate-otp")
    public ResponseEntity<String> sendOtp(@RequestBody User user) {
		String userEmail=user.getEmail();
		User u=registerService.findByEmail(userEmail);
		if(u==null) {
			String otp=otpService.generateOtp(userEmail);
			emailService.sendOtpEmail(userEmail, otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return ResponseEntity.badRequest().body("Email is already registered.");
			
		}
		
		}

    
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp( @RequestBody  OtpVerificationRequest verificationRequest) {
        String otp=verificationRequest.getOtp();
        String email=verificationRequest.getEmail();
        System.out.println(otp+email);

        if (otpService.validateOtp(email, otp)) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Incorrect OTP.");
        }

    }
    @PostMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(updateUser.getName());
        userResponse.setEmail(updateUser.getEmail());
        userResponse.setAccountNumber(updateUser.getAccount().getAccountNumber());
        userResponse.setIFSC_code(updateUser.getAccount().getIFSC_code());
        userResponse.setBranch(updateUser.getAccount().getBranch());
        userResponse.setAccount_type(updateUser.getAccount().getAccount_type());


        return ResponseEntity.ok(userResponse);
    }

}
