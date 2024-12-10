package br.com.curso_spring;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Startup {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Startup.class, args);
//	}
//
//}
//===================================================================================

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

@SpringBootApplication
public class Startup {

  public static void main(String[] args) {
      SpringApplication.run(Startup.class, args);
      
      Map<String, PasswordEncoder> encoders = new HashMap<>();
      
      Pbkdf2PasswordEncoder pbkdf2Enconder = new Pbkdf2PasswordEncoder("" , 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
      
      encoders.put("pbkdf2", pbkdf2Enconder);
      DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
      passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Enconder);
      
      String result1 = passwordEncoder.encode("admin123");
      String result2 = passwordEncoder.encode("admin321");
      System.out.println("My hash result1 " + result1); // My hash result1 {pbkdf2}50e7ecc5c9773fb933f4f681719b19a63cfc88cbded1a6147e952ac4f5c0160152e51c08b825fee9
      
      System.out.println("My hash result2 " + result2); // My hash result2 {pbkdf2}ed7abf85bc7005577c4eb082799dd899b804305189f0ea5be823eb90930e1a77855bfb73c3872821
   
  }
}