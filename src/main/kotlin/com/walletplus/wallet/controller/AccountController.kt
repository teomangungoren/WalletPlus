package com.walletplus.wallet.controller

import com.walletplus.wallet.dto.AccountDto
import com.walletplus.wallet.dto.CreateAccountRequest
import com.walletplus.wallet.dto.CustomerDto
import com.walletplus.wallet.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/account")
class AccountController(private val accountService: AccountService) {

    @GetMapping
    fun getAllAccounts(): ResponseEntity<List<AccountDto>> {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable id:String):ResponseEntity<AccountDto>{
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @PostMapping
    fun createAccount(@RequestBody createAccountRequest: CreateAccountRequest):ResponseEntity<AccountDto>{
        val createdAccount=accountService.createAccount(createAccountRequest);
        return ResponseEntity(createdAccount,HttpStatus.CREATED);
    }
}