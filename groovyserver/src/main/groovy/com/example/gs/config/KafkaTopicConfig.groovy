package com.example.gs.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig {
    @Value('${kafka.bootstrapAddress}')
    String bootstrapAddress

    @Bean
    KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>()
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress)
        new KafkaAdmin(config)
    }

    @Bean
    NewTopic orderTopic() {
        new NewTopic("orders", 1, (short) 1)
    }
}
