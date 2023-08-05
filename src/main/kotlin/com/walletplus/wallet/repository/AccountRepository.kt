package com.walletplus.wallet.repository

import com.walletplus.wallet.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository:JpaRepository<Account, String> {
}