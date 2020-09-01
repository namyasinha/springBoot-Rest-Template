package io.namya.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.namya.profiles.models.status;

@SpringBootApplication
@RestController
public class TodostatusserviceApplication {
	
	@GetMapping("/todo/{id}")
	public status getStatus(@PathVariable int id) {
		return new status(id,"not completed");
	}

	public static void main(String[] args) {
		SpringApplication.run(TodostatusserviceApplication.class, args);
	}

}
