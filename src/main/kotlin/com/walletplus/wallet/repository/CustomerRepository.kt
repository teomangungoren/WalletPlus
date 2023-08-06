package com.walletplus.wallet.repository

import com.walletplus.wallet.dto.CustomerDto
import com.walletplus.wallet.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository:JpaRepository<Customer,String> {
    fun findCustomerByTcNo(tc:String):Customer
}