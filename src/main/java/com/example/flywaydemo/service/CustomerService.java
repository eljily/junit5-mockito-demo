package com.example.flywaydemo.service;

import com.example.flywaydemo.dtos.CustomerDTO;
import com.example.flywaydemo.dtos.CustomerResponseDTO;
import com.example.flywaydemo.entity.Customer;
import com.example.flywaydemo.mappers.CustomerMapper;
import com.example.flywaydemo.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDTO saveCustomer(CustomerDTO customerDTO){
        var customer = customerMapper.toCustomer(customerDTO);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerResponseDto(savedCustomer);
    }

    public List<CustomerResponseDTO> findAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }
    public CustomerResponseDTO findCustomerById(Integer id){
        return customerRepository.findById(id).map(customerMapper::toCustomerResponseDto)
                .orElse(null);
    }
}
