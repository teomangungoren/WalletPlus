package com.walletplus.wallet.repository

import com.walletplus.wallet.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository:JpaRepository<Customer,String> {
}