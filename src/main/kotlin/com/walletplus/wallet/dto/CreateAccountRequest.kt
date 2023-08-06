package com.walletplus.wallet.dto

import com.walletplus.wallet.model.Currency
import java.math.BigDecimal

data class CreateAccountRequest(
        val customerTc:String,
        val balance:BigDecimal,
        val currency:Currency
)
