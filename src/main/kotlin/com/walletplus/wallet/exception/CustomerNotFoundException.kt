package com.walletplus.wallet.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class CustomerNotFoundException(s:String):RuntimeException(s) {
}