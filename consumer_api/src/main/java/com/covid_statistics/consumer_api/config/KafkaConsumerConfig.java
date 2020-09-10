package com.covid_statistics.consumer_api.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;



import com.covid_statistics.consumer_api.model.cases;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	
	
	@Bean
	public ConsumerFactory<String, cases> userConsumerFactory() {
		
		JsonDeserializer<cases> deserializer = new JsonDeserializer<>(cases.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,deserializer);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "covid-statistic");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,cases> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, cases> factory = new ConcurrentKafkaListenerContainerFactory<String, cases>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}


}
