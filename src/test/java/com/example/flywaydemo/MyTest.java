package com.example.flywaydemo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


public class MyTest {
    private static int n;
    @BeforeEach
    void setUp(){
        System.out.println("inside before each methode");
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Inside before all method");
        n = 1;
    }
    @AfterEach
    void tearDown(){
        System.out.println("Inside the before each method");
    }
    @Test
    void oneEqualOne(){
        Assertions.assertEquals(1,n);
    }
    @Test
    void twoGreaterThanOne(){
        Assertions.assertNotEquals(2,n);
    }
}
