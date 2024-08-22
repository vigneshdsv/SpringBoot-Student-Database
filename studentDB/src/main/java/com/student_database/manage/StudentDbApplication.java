package com.student_database.manage;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentDbApplication {

	public static void main(String[] args) {

		final var app = new SpringApplication(StudentDbApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

}
