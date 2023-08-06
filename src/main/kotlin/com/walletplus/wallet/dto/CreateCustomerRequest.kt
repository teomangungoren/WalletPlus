package com.walletplus.wallet.dto

import com.walletplus.wallet.model.City

data class CreateCustomerRequest(
        val id:String,
       val name:String,
        val surname:String,
        val tcNo:String,
        val mail:String,
        val city:City,
        val phoneNumber:String

) {
}