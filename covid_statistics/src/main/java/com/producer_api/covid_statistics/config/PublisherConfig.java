package com.producer_api.covid_statistics.config;

import com.producer_api.covid_statistics.model.cases;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;




@Configuration
public class PublisherConfig {
	@Bean
	public ProducerFactory<String, cases> producerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		//configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, cases.class);
		return new DefaultKafkaProducerFactory<String, cases>(configs);
	}

	@Bean
	public KafkaTemplate<String, cases> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}


}
