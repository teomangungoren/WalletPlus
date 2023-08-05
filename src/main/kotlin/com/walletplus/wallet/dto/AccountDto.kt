package com.walletplus.wallet.dto

import com.walletplus.wallet.model.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
        val id:String?,
        val balance:BigDecimal?,
        val currency:Currency?,
        val createdDate:LocalDateTime?,
        val customer:CustomerDto?
)
