package com.bhavicodes.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}") // input topic name from the spring application.properties file
    public String topic;

    // spring bean for kafka topic
    @Bean
    public NewTopic topic()
    {
       return TopicBuilder.name("order_topics").build();
    }

}
