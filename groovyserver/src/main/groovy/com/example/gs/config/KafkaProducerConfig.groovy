package com.example.gs.config

import com.example.gs.model.Order
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.protocol.types.Field
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaProducerConfig {
    @Value('${kafka.bootstrapAddress}')
    String bootstrapAddress

    @Bean
    ProducerFactory<String, Order> producerFactory() {
        Map<String, Object> config = new HashMap<>()
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class)
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class)
        new DefaultKafkaProducerFactory<String, Order>(config)
    }

    @Bean
    KafkaTemplate<String, Order> kafkaTemplate() {
        new KafkaTemplate<String, Order>(producerFactory())
    }
}
