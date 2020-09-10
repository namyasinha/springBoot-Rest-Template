package com.producer_api.covid_statistics;


import com.producer_api.covid_statistics.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CovidStatisticsApplication {
	@Autowired
	private  KafkaTemplate<String,cases> template;
	
	private  String topic="covidStatistic";
	@GetMapping("/produce")
	public void function() {
		RestTemplate resttemplate=new RestTemplate();
		cases st=resttemplate.getForObject("http://covid19-india-adhikansh.herokuapp.com/states",cases.class);
		template.send(topic,st);
		
		
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(CovidStatisticsApplication.class, args);
		
	}

}
