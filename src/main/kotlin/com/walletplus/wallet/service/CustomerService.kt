package com.walletplus.wallet.service

import com.walletplus.wallet.dto.CreateCustomerRequest
import com.walletplus.wallet.dto.CustomerDto
import com.walletplus.wallet.exception.CustomerNotFoundException
import com.walletplus.wallet.model.Customer
import com.walletplus.wallet.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun createCustomer(createCustomerRequest: CreateCustomerRequest):CustomerDto{
        val customer=Customer(
                createCustomerRequest.id,
                createCustomerRequest.name,
                createCustomerRequest.surname,
                createCustomerRequest.tcNo,
                createCustomerRequest.mail,
                createCustomerRequest.city,
                createCustomerRequest.phoneNumber,
                LocalDateTime.now(),
                null
        )
        return CustomerDto.convert(customerRepository.save(customer));
    }

    fun getAllCustomers():List<CustomerDto>{
        return customerRepository.findAll()
                .stream()
                .map(CustomerDto::convert)
                .collect(Collectors.toList());
    }

    fun findCustomerByTC(tc:String):Customer{
        return customerRepository.findCustomerByTcNo(tc);
    }
}