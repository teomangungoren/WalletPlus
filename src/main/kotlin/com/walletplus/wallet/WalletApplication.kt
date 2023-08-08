package com.walletplus.wallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement


@SpringBootApplication
@EnableTransactionManagement
class WalletApplication

fun main(args: Array<String>) {
	runApplication<WalletApplication>(*args)
}






