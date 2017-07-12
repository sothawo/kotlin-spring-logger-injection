package com.sothawo

import org.slf4j.Logger
import org.springframework.stereotype.Service

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Service
class HelloService {

    @Slf4jLogger
    lateinit var log: Logger

    fun sayHello(name: String): String {
        log.info("saying hello to: $name")
        return "hello $name"
    }
}
