package com.walletplus.wallet.service

import com.walletplus.wallet.dto.CreateTransactionRequest
import com.walletplus.wallet.dto.TransactionDto
import com.walletplus.wallet.model.Transaction
import com.walletplus.wallet.repository.AccountRepository
import com.walletplus.wallet.repository.TransactionRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class TransactionService(private val transactionRepository: TransactionRepository,
                         private val accountService: AccountService,
                         private val accountRepository: AccountRepository, ) {

    @Transactional(readOnly = false, timeout = 5)
    fun transferMoney(createTransactionRequest: CreateTransactionRequest): TransactionDto? {
        val sender=accountService.findAccountById(createTransactionRequest.senderAccountId);
        val receiver=accountService.findAccountById(createTransactionRequest.receiverAccountId);

        if(sender!=null && receiver!=null){
            if(sender.balance!!>=createTransactionRequest.amount){
                sender.balance=sender.balance!!.subtract(createTransactionRequest.amount);
                receiver.balance=receiver.balance!!.add(createTransactionRequest.amount);

                accountRepository.save(sender);
                accountRepository.save(receiver);

                val transaction=Transaction(
                        createTransactionRequest.amount,
                        LocalDateTime.now(),
                        sender
                )

                transactionRepository.save(transaction);

                return TransactionDto.convert(transaction);

            }
        }
        return null;
    }

    fun getTransactions():List<TransactionDto>{
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::convert)
                .collect(Collectors.toList());
    }


}