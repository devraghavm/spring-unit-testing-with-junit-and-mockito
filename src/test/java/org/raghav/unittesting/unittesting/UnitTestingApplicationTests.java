package org.raghav.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = {"classpath:test-configuration.yml"})
class UnitTestingApplicationTests {

    @Test
    void contextLoads() {
    }

}
