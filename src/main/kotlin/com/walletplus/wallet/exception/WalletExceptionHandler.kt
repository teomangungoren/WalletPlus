package com.walletplus.wallet.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class WalletExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException::class)
    fun handleCustomerException(exception:CustomerNotFoundException):ResponseEntity<Any>{
        return ResponseEntity(exception.message,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AccountNotFoundException::class)
    fun handleAccountException(exception: AccountNotFoundException):ResponseEntity<Any>{
        return ResponseEntity(exception.message,HttpStatus.NOT_FOUND);
    }
}