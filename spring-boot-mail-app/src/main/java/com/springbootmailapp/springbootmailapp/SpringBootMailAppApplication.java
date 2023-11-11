package com.springbootmailapp.springbootmailapp;

import com.springbootmailapp.springbootmailapp.controller.MailController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMailAppApplication implements CommandLineRunner {

	private MailController mailController;

	public SpringBootMailAppApplication(MailController mailController) {
		this.mailController = mailController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMailAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mailController.sendMail();
	}

}
