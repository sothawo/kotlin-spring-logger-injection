package com.sothawo

import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@RestController
@RequestMapping("/hello")
class HelloController(val helloService: HelloService) {

    @GetMapping("/{name}")
    fun sayHello(@PathVariable name: String): ResponseEntity<String> {
        log.info("sayHello called with arg $name")
        return ResponseEntity.ok(helloService.sayHello(name))
    }

    companion object {
        @Slf4jLogger
        lateinit var log: Logger
    }
}
