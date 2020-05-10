package jp.co.test.controller

import org.junit.Rule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
@WebMvcTest(controllers = HelloController)
@ContextConfiguration
@TestPropertySource(locations = "/application.yml")
@ImportAutoConfiguration
class HelloControllerTest extends Specification {
    @Rule
    MockitoRule rule = MockitoJUnit.rule()

//    @Autowired
//    private MockMvc mockMvc;

    def "test properties"() {
        given:
        expect:
        println "jp.co.hello"
    }
}
