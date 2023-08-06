package com.walletplus.wallet.dto

import com.walletplus.wallet.model.Account
import com.walletplus.wallet.model.Currency
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
        val id:String?,
        var balance:BigDecimal?,
        val currency:Currency?,
        val createdDate:LocalDateTime?,
        val customerTc:String?,

){
    companion object{
        @JvmStatic
        fun convert(from:Account):AccountDto{
            return AccountDto(
                    from.id,
                    from.balance,
                    from.currency,
                    from.createdDate,
                    from.customer?.tcNo
                      )

        }
    }
}
