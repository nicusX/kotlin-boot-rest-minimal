package it.nicus.kotlinboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingEndpointIntegrationTest(@Autowired var restTemplate: TestRestTemplate) {

    @Test
    fun `Greeting endpoint returns "Hello, World" when no name is specified`() {
        val entity = restTemplate.getForEntity("/greeting", Greeting::class.java)

       assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
       assertThat(entity.body?.content).isEqualTo("Hello, World")
    }


    @Test
    fun `Greeting endpoint returns "Hello, {name}" when a name is specified`() {
        val params = mapOf("name" to "MyName")
        val entity = restTemplate.getForEntity("/greeting?name={name}", Greeting::class.java, params)

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body?.content).isEqualTo("Hello, MyName")
    }

}