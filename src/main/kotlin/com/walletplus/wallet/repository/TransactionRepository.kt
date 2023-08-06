package com.walletplus.wallet.repository

import com.walletplus.wallet.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository:JpaRepository<Transaction,String> {

}