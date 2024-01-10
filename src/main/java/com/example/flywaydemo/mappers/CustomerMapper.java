package com.example.flywaydemo.mappers;

import com.example.flywaydemo.dtos.CustomerDTO;
import com.example.flywaydemo.dtos.CustomerResponseDTO;
import com.example.flywaydemo.entity.Customer;

public class CustomerMapper {

    public Customer toCustomer(CustomerDTO dto){
        if(dto == null) {
            throw new NullPointerException("customerDt should not be null");
        }
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        return customer;
    }

    public CustomerDTO toCustomerDto(Customer customer){
        if(customer == null) {
            throw new NullPointerException("customer should not be null");
        }
        CustomerDTO customerDTO =new CustomerDTO();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setId(customer.getId());
        return customerDTO;
    }
    public CustomerResponseDTO toCustomerResponseDto(Customer customer){
        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
        customerResponseDTO.setFirstName(customer.getFirstName());
        customerResponseDTO.setLastName(customer.getLastName());
        return customerResponseDTO;
    }
}
