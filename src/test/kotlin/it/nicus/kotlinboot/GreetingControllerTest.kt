package it.nicus.kotlinboot

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString

class GreetingControllerTest {

    @Test
    fun `greeting should return Greeting with specified content`() {
        val service = mock<GreetingService> {
            on { greeting( anyString()) } doReturn Greeting(1, "-content-")
        }
        val sut = GreetingController(service)


        val result = sut.greeting("-content-")

        assertThat(result.content).isEqualTo("-content-")

        verify(service).greeting("-content-")
        verifyNoMoreInteractions(service)
    }
}