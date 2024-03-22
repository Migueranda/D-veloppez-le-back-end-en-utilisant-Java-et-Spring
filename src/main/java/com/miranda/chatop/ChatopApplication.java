package com.miranda.chatop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan("com.miranda.chatop")
public class ChatopApplication{
	public static void main(String[] args) {
		SpringApplication.run(ChatopApplication.class, args);
	}

}
