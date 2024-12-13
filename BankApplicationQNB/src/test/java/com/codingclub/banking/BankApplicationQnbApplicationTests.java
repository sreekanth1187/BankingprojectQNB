package com.codingclub.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codingclub.banking.controller.ApiController;
import com.codingclub.banking.entity.UserCreationMaster;
import com.codingclub.banking.service.Serviceclass;

@SpringBootTest
class BankApplicationQnbApplicationTests {

    @Mock
    private Serviceclass serviceclass; // Mocking the service layer

    @InjectMocks
    private ApiController apicontroller; // Injecting mocks into the controller

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks and injects them into the controller
    }

    @Test
    void contextLoads() {
        // This test checks if the application context loads successfully
    }

    @Test
    public void testUserCreation_DuplicateLoginId() throws Exception {
        // Arrange: Create a sample user with a duplicate login ID
        UserCreationMaster user = new UserCreationMaster();
        user.setLoginid("ukpbkmkr6");

        // Mock the service to return true (indicating a duplicate login ID)
       //fa when(serviceclass.DupliacteLoginId(any(UserCreationMaster.class))).thenReturn(true);

        // Act: Call the controller method
        //ResponseEntity<String> response = apicontroller.usercreation(user);

        // Assert: Check that the response indicates a duplicate login ID
        //assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        //assertEquals("Login ID Already Exists", response.getBody());
    }
}
