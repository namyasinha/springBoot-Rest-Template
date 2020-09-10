package com.covid_statistics.consumer_api;

import com.covid_statistics.consumer_api.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumerApiApplication {
	
	
	
	cases topicContent=null;
	
	@GetMapping("/coronaStatistic")
	@CrossOrigin(origins = "http://localhost:4200")
	public cases getStatistic() {
		return topicContent;
	}
	
	
	@KafkaListener(groupId = "covid-statistic", topics = "covidStatistic", containerFactory = "userKafkaListenerContainerFactory")
	public cases getJsonMsgFromTopic(cases statistic) {
		topicContent = statistic;
		return topicContent;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApiApplication.class, args);
	}

}
