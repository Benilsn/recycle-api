package com.recycle.Recycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("application.properties")
public class RecycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecycleApplication.class, args);

	}

}


