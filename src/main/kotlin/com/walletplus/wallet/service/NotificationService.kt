package com.walletplus.wallet.service

import com.walletplus.wallet.dto.TransactionEvent
import org.apache.kafka.clients.admin.NewTopic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class NotificationService(private val topic:NewTopic,private val kafkaTemplate: KafkaTemplate<String,TransactionEvent>) {

    private val logger:Logger=LoggerFactory.getLogger(NotificationService::class.java);

    fun sendMessage(event:TransactionEvent):Unit{
        logger.info(String.format("Transaction event => \n %s",event.toString()));
        val message: Message<TransactionEvent> = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

}