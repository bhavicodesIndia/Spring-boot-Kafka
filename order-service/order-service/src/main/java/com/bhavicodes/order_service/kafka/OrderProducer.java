package com.bhavicodes.order_service.kafka;

import com.bhavicodes.base_domains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.shaded.com.google.protobuf.MessageOrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class OrderProducer {


    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);
    @Autowired
    private final NewTopic topic;
    @Autowired
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;


    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }


    public void sendMessage(OrderEvent orderEvent) {
        logger.info(String.format("🚀 Sending order event: {" + orderEvent.toString() + "}"));
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, "order_topics")
                .build();
        kafkaTemplate.send(message);
    }
}
