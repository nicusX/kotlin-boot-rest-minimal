package it.nicus.kotlinboot

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class GreetingService {
    val counter = AtomicLong()

    fun greeting(name: String) =  Greeting(counter.incrementAndGet(), "Hello, $name")
}