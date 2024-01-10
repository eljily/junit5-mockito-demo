package com.example.flywaydemo.service;

import com.example.flywaydemo.dtos.CustomerDTO;
import com.example.flywaydemo.dtos.CustomerResponseDTO;
import com.example.flywaydemo.entity.Customer;
import com.example.flywaydemo.mappers.CustomerMapper;
import com.example.flywaydemo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    //which service we want to test
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void should_successfully_save_a_customer(){
        //Given
        CustomerDTO customerDTO=CustomerDTO.builder()
                .id(123)
                .firstName("joe")
                .lastName("doe")
                .build();
        Customer customer=Customer.builder()
                .id(123)
                .firstName("joe")
                .lastName("doe")
                .build();
        Customer savedCustomer=Customer.builder()
                .id(123)
                .firstName("joe")
                .lastName("doe")
                .phoneNumber("1234")
                .email("test@gmail.com")
                .build();
        //Mock the calls
        Mockito.when(customerMapper.toCustomer(customerDTO)).thenReturn(customer);
        Mockito.when(customerRepository.save(customer)).thenReturn(savedCustomer);
        Mockito.when(customerMapper.toCustomerResponseDto(savedCustomer))
                .thenReturn(new CustomerResponseDTO("joe","doe"));
        //When
        CustomerResponseDTO customerResponseDTO=customerService.saveCustomer(customerDTO);
        //Then
        Assertions.assertEquals(customerDTO.getFirstName(),customerResponseDTO.getFirstName());
        Assertions.assertEquals(customerDTO.getLastName(),customerResponseDTO.getLastName());
        Mockito.verify(customerMapper,
                Mockito.times(1)).toCustomer(customerDTO);
        Mockito.verify(customerRepository,
                Mockito.times(1)).save(customer);
        Mockito.verify(customerMapper,
                Mockito.times(1)).toCustomerResponseDto(savedCustomer);
    }

    @Test
    public void should_return_all_customers(){
        //Given
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .id(123)
                .firstName("joe")
                .lastName("doe")
                .phoneNumber("1234")
                .email("test@gmail.com")
                .build());
        //Mock the calls
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        Mockito.when(customerMapper.toCustomerResponseDto(Mockito.any(Customer.class))).thenReturn(
               new CustomerResponseDTO("joe","doe")
        );
        //When
        List<CustomerResponseDTO> responseDTOS=customerService.findAllCustomers();
        //Then
        Assertions.assertEquals(responseDTOS.size(),customers.size());
        Mockito.verify(customerRepository,Mockito.times(1)).findAll();
    }
    @Test
    public void should_find_customer_by_id(){
        //Given
        Customer customer= Customer.builder()
                .id(9)
                .firstName("test")
                .lastName("test")
                .build();
        //Mock the calls
        Mockito.when(customerRepository.findById(9))
                .thenReturn(Optional.of(customer));
        Mockito.when(customerMapper.toCustomerResponseDto(customer)).thenReturn(new CustomerResponseDTO("test","test"));
        //when
        CustomerResponseDTO customerResponseDTO1=customerService.findCustomerById(9);
        //then
        Assertions.assertEquals(customerResponseDTO1.getFirstName(),customer.getFirstName());
        Assertions.assertEquals(customerResponseDTO1.getLastName(),customer.getLastName());
        Mockito.verify(customerRepository,Mockito.times(1)).findById(9);
    }
}