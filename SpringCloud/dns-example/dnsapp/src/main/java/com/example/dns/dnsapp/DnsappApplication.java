package com.example.dns.dnsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DnsappApplication {

	@RestController
	class HelloController{
		@GetMapping("/hello")
		public String hello() {
			return "long time no see";
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(DnsappApplication.class, args);
	}

}
