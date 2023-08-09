package com.walletplus.wallet.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig(@Value("\${spring.kafka.topic.name}") private val topicName: String) {

    @Bean
    fun topic():NewTopic{
        return TopicBuilder.name(topicName)
                .build();
    }
}