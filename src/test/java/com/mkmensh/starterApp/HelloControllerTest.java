package com.mkmensh.starterApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class HelloControllerTest {

    @Test
    void helloMethodReturnsGreeting() {
        HelloController controller = new HelloController();

        ResponseEntity<String> response = controller.hello();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello from starterApp!", response.getBody());
    }
}
