package io.namya.profiles;
import io.namya.profiles.models.Task;
import io.namya.profiles.models.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class TodotaskserviceApplication {
	
	@GetMapping("/todo/{id}")
	public Task getTodo(@PathVariable int id){
		RestTemplate restTemplate =new RestTemplate();
		status st=restTemplate.getForObject("http://localhost:4000/todo/"+id,status.class);
		return new Task(id,"study",st.getStatus());
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TodotaskserviceApplication.class, args);
	}

}
