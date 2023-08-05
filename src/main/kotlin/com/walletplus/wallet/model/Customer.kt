package com.walletplus.wallet.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

data class Customer(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String?,
        val name:String?,
        val surname:String?,
        val tcNo:String?,
        @Enumerated(EnumType.STRING)
        val city:City?,
        val phoneNumber:String?,
        @JsonFormat(pattern = "yyyy-MM-dd")
        val createdDate:LocalDateTime?= LocalDateTime.now(),

        @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
        val account:Account?
) {
}