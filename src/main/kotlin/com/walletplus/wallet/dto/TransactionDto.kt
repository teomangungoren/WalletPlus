package com.walletplus.wallet.dto

import com.walletplus.wallet.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

    data class TransactionDto(
            val id:String?,
            val amount:BigDecimal?,
            val transactionDate:LocalDateTime?,
            val accountId:String?,
            ) {

        companion object{
            @JvmStatic
            fun convert(from:Transaction):TransactionDto{
                    return TransactionDto(
                            from.id,
                            from.amount,
                            from.transactionDate,
                            from.account?.id
                    )
            }
        }
}