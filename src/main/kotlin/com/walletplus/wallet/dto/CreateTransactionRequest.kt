package com.walletplus.wallet.dto

import java.math.BigDecimal

data class CreateTransactionRequest(
        val senderAccountId:String,
        val receiverAccountId:String,
        val amount:BigDecimal?=BigDecimal(100),

) {
}