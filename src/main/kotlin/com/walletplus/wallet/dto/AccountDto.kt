package com.walletplus.wallet.dto

import com.walletplus.wallet.model.Account
import com.walletplus.wallet.model.Currency
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Objects

data class AccountDto(
        val id:String?,
        val balance:BigDecimal?,
        val currency:Currency?,
        val createdDate:LocalDateTime?,
        val customer:CustomerDto?
){
    constructor():this(null,null,null,null,null);
    companion object{
        @JvmStatic
        fun convert(from:Account):AccountDto{
           val customerDto=from.customer?.let { CustomerDto.convert(it) }?:CustomerDto()
            return AccountDto(
                    from.id,
                    from.balance,
                    from.currency,
                    from.createdDate,
                    customerDto
                      )

        }
    }
}
