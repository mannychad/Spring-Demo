package com.spring.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	String test() {
		return "Hello World";
	}
    public static void main( String[] args )
    {
    		SpringApplication.run(App.class, args);
    }
}
