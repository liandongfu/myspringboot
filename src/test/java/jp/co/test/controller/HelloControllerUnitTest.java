package jp.co.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("HelloController Unit Tests")
class HelloControllerUnitTest {

    private HelloController helloController;

    @BeforeEach
    void setUp() {
        helloController = new HelloController();
    }

    @Test
    @DisplayName("Should return hello world message")
    void testIndexMethod() {
        String result = helloController.index();
        
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("jp.co.hello world");
    }

    @Test
    @DisplayName("Should return string containing 'hello'")
    void testIndexContainsHello() {
        String result = helloController.index();
        
        assertThat(result).contains("hello");
    }

    @Test
    @DisplayName("Should return string containing 'world'")
    void testIndexContainsWorld() {
        String result = helloController.index();
        
        assertThat(result).contains("world");
    }

    @Test
    @DisplayName("Should return string starting with 'jp.co'")
    void testIndexStartsWithPrefix() {
        String result = helloController.index();
        
        assertThat(result).startsWith("jp.co");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jp.co", "hello", "world"})
    @DisplayName("Should contain expected substrings")
    void testIndexContainsExpectedSubstrings(String substring) {
        String result = helloController.index();
        
        assertThat(result).contains(substring);
    }
}
