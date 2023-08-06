package com.walletplus.wallet.service

import com.walletplus.wallet.model.Account
import com.walletplus.wallet.repository.AccountRepository
import com.walletplus.wallet.repository.TransactionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class TransactionService(private val transactionRepository: TransactionRepository,
                         private val accountService: AccountService,
                         private val accountRepository: AccountRepository) {

    @Transactional
    fun transferMoney(senderId:String,receiverId:String,amount:BigDecimal){
        val sender=accountService.findAccountById(senderId);
        val receiver=accountService.findAccountById(receiverId);
    }
}