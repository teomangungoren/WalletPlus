package com.walletplus.wallet.dto

class TransactionEvent(
        private val message:String,
        private val status:String,
        private val transaction:TransactionDto?
) {
}