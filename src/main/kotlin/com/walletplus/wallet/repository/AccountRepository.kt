package com.walletplus.wallet.repository

import com.walletplus.wallet.dto.AccountDto
import com.walletplus.wallet.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository:JpaRepository<Account, String> {
    fun findAccountById(id:String):Account?;
}