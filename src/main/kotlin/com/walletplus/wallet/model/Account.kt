package com.walletplus.wallet.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class Account(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String?="",
        val balance:BigDecimal?= BigDecimal.ZERO,
        @Enumerated(EnumType.STRING)
        val currency:Currency?=Currency.TRY,
        @JsonFormat(pattern = "yyyy-MM-dd")
        val createdDate:LocalDateTime?= LocalDateTime.now(),

        @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="customer_id")
        val customer:Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        val transaction:Set<Transaction>?=null
        ) {


}