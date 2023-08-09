package com.walletplus.wallet.controller

import com.walletplus.wallet.dto.CreateTransactionRequest
import com.walletplus.wallet.dto.TransactionDto
import com.walletplus.wallet.dto.TransactionEvent
import com.walletplus.wallet.service.NotificationService
import com.walletplus.wallet.service.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/transaction")
class TransactionController(private val transactionService: TransactionService,
                            private val notificationService: NotificationService){

    @GetMapping
    fun getTransactions():ResponseEntity<List<TransactionDto>>{
        return ResponseEntity.ok(transactionService.getTransactions());
    }

    @PostMapping
    fun createTransaction(@RequestBody createTransactionRequest: CreateTransactionRequest):ResponseEntity<TransactionDto>{
        val createdTransaction=transactionService.transferMoney(createTransactionRequest);
        val transactionEvent:TransactionEvent= TransactionEvent("Pending",
                "transaction status is in pending state",createdTransaction);
        notificationService.sendMessage(transactionEvent);
        return ResponseEntity(createdTransaction,HttpStatus.CREATED);
    }
}