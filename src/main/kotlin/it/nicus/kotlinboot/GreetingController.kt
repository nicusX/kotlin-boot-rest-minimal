package it.nicus.kotlinboot

import org.slf4j.LoggerFactory.getLogger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController(val service: GreetingService) {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        log.debug("Greeting request received: name={}", name)
        return service.greeting(name)
    }


    companion object {
        private val log = getLogger(GreetingController::class.java)
    }
}
