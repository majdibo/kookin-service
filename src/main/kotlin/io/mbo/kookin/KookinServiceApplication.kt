package io.mbo.kookin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KookinServiceApplication

fun main(args: Array<String>) {
    runApplication<KookinServiceApplication>(*args)
}
