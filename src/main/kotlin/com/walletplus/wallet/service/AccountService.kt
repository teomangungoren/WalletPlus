package com.walletplus.wallet.service

import com.walletplus.wallet.dto.AccountDto
import com.walletplus.wallet.dto.CreateAccountRequest
import com.walletplus.wallet.dto.CustomerDto
import com.walletplus.wallet.model.Account
import com.walletplus.wallet.repository.AccountRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class AccountService(private val accountRepository: AccountRepository,private val customerService: CustomerService) {

    fun getAllAccounts():List<AccountDto>{
        return accountRepository.findAll()
                .stream()
                .map(AccountDto::convert)
                .collect(Collectors.toList());
    }

    fun findAccountById(id:String):Account?{
        return accountRepository.findAccountById(id)
    }

    fun createAccount(createAccountRequest: CreateAccountRequest):AccountDto{
        val customer=createAccountRequest.customerTc?.let { customerService.findCustomerByTC(it) };
        val account=Account("",createAccountRequest.balance,createAccountRequest.currency, LocalDateTime.now(),
                customer,null);
        return AccountDto.convert(accountRepository.save(account));

    }
}