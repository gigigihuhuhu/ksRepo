package com.ksproject.ksproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@SpringBootApplication
public class KsprojectApplication {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "또이거냐";
	}
	public static void main(String[] args) {
		SpringApplication.run(KsprojectApplication.class, args);
	}

}
