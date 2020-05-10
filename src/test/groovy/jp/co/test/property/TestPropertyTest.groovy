package jp.co.test.property

import org.junit.Rule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
@ContextConfiguration
//@Import(TestProperty.class)
@TestPropertySource(properties = ["test.test1:aa", "test.test2:bb"])
class TestPropertyTest extends Specification {
    @Rule
    MockitoRule rule = MockitoJUnit.rule()

//    @Autowired
//    TestProperty testProperty

//    @Autowired
//    Hello jp.co.hello

    def "test set Test1"() {
        given:
//        println testProperty.getTest1()
        Hello hello = new Hello()
        println hello.getTest1()
    }

    @Component
    @ConfigurationProperties(prefix = "test")
    static class Hello {
        String getTest1() {
            return test1
        }

        void setTest1(String test1) {
            this.test1 = test1
        }

        String getTest2() {
            return test2
        }

        void setTest2(String test2) {
            this.test2 = test2
        }
        private String test1
        private String test2
    }

}
