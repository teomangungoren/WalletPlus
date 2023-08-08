package com.walletplus.wallet.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class NotificationService {

    private val logger:Logger=LoggerFactory.getLogger(NotificationService::class.java);

    @KafkaListener(topics = ["transfer-notification"], groupId = "group-id")
     fun consume(message:String){
          logger.info(String.format("Message receiver \n %s",message));
    }


}