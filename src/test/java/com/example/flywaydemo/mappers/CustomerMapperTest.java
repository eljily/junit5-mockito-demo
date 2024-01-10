package com.example.flywaydemo.mappers;

import com.example.flywaydemo.dtos.CustomerDTO;
import com.example.flywaydemo.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerMapperTest {

    private CustomerMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CustomerMapper();
    }

    @Test
    void toCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(12)
                .firstName("sidi")
                .lastName("brahim")
                .build();
        Customer customer = mapper.toCustomer(customerDTO);
        Assertions.assertNotNull(customerDTO.getFirstName());
        Assertions.assertEquals(customerDTO.getId(),customer.getId());
        Assertions.assertEquals(customerDTO.getFirstName(),customer.getFirstName());
        Assertions.assertEquals(customerDTO.getLastName(),customer.getLastName());

    }

    @Test
    void toCustomerDto() {
        //Given
        Customer customer = Customer.builder()
                .id(1)
                .firstName("salem")
                .lastName("oumar")
                .phoneNumber("12345654")
                .email("email@domain.com")
                .build();
        //When
        CustomerDTO customerDTO = mapper.toCustomerDto(customer);
        //Then
        Assertions.assertNotNull(customer.getFirstName());
        Assertions.assertEquals(customerDTO.getId(),customer.getId());
        Assertions.assertEquals(customerDTO.getFirstName(),customer.getFirstName());
        Assertions.assertEquals(customerDTO.getLastName(),customer.getLastName());
    }
    @Test
    public void should_throw_null_pointer_exception_when_customerDto_is_null(){
        var exp = Assertions.assertThrows(NullPointerException.class,()->mapper.toCustomer(null));
        Assertions.assertEquals("customerDt should not be null",exp.getMessage());
    }

}