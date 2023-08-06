package com.walletplus.wallet.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class Customer(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String?,
        val name:String?,
        val surname:String?,
        val tcNo:String?,
        val mail:String?,
        @Enumerated(EnumType.STRING)
        val city:City?,
        val phoneNumber:String?,
        @JsonFormat(pattern = "yyyy-MM-dd")
        val createdDate:LocalDateTime?= LocalDateTime.now(),

        @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
        val account:Account?
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Customer

                if (id != other.id) return false
                if (name != other.name) return false
                if (surname != other.surname) return false
                if (tcNo != other.tcNo) return false
                if (mail != other.mail) return false
                if (city != other.city) return false
                if (phoneNumber != other.phoneNumber) return false
                if (createdDate != other.createdDate) return false
                return account == other.account
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (name?.hashCode() ?: 0)
                result = 31 * result + (surname?.hashCode() ?: 0)
                result = 31 * result + (tcNo?.hashCode() ?: 0)
                result = 31 * result + (mail?.hashCode() ?: 0)
                result = 31 * result + (city?.hashCode() ?: 0)
                result = 31 * result + (phoneNumber?.hashCode() ?: 0)
                result = 31 * result + (createdDate?.hashCode() ?: 0)
                result = 31 * result + (account?.hashCode() ?: 0)
                return result
        }
}