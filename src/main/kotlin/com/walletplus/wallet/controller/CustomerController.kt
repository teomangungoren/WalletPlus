package com.walletplus.wallet.controller

import com.walletplus.wallet.dto.CreateCustomerRequest
import com.walletplus.wallet.dto.CustomerDto
import com.walletplus.wallet.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customer")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers():ResponseEntity<List<CustomerDto>>{
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    fun createCustomer(@RequestBody createCustomerRequest: CreateCustomerRequest):ResponseEntity<CustomerDto>{
        val createdCustomer=customerService.createCustomer(createCustomerRequest);
        return ResponseEntity(createdCustomer,HttpStatus.CREATED);
    }

}