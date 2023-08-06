package com.walletplus.wallet.dto

import com.walletplus.wallet.model.City
import com.walletplus.wallet.model.Customer
import java.time.LocalDateTime

data class CustomerDto(
        val id:String?,
        val name:String?,
        val surname:String?,
        val tcNo:String?,
        val mail:String?,
        val city:City?,
        val phoneNumber:String?,
        val createdDate:LocalDateTime?,
        val account:AccountDto?
){

    constructor():this(null,null,null,null,null,null,null,null,null)
    companion object{
        @JvmStatic
        fun convert(from:Customer):CustomerDto{
            val accountDto=from.account?.let { AccountDto.convert(it) }?:AccountDto()
            return CustomerDto(

                    from.id,
                    from.name,
                    from.surname,
                    from.tcNo,
                    from.mail,
                    from.city,
                    from.phoneNumber,
                    from.createdDate,
                    accountDto
            )
        }
    }
}
