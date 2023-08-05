package com.walletplus.wallet.dto

import com.walletplus.wallet.model.City
import java.time.LocalDateTime

data class CustomerDto(
        val id:String?,
        val name:String?,
        val surname:String?,
        val mail:String?,
        val city:City?,
        val phoneNumber:String?,
        val createdDate:LocalDateTime?,
        val account:AccountDto
)
