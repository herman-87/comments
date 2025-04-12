package com.fastrelay.comments.commons;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.reactive.server.WebTestClient;

public abstract class BaseControllerTest {
    protected WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToController(getControllerInstanceToTest()).build();
    }

    public abstract Object getControllerInstanceToTest();
}
