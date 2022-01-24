package com.mshri.app;

import com.mshri.app.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Driver;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private DriverService driverService;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	driverService.runApp();
	}
}
