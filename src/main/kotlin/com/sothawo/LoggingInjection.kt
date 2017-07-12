package com.sothawo

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMemberProperties

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */

@Target(AnnotationTarget.PROPERTY)
annotation class Slf4jLogger

@Component
class LoggingInjector : BeanPostProcessor {

    override fun postProcessBeforeInitialization(bean: Any?, beanName: String?): Any? {
        bean?.let {
            val loggerName = it::class.java.canonicalName
            processObject(it, loggerName)
            it::class.companionObjectInstance?.let {
                processObject(it, loggerName)
            }
        }

        return bean
    }

    override fun postProcessAfterInitialization(bean: Any?, beanName: String?) = bean

    private fun processObject(target: Any, loggerName: String) {
        target::class.declaredMemberProperties.forEach {
            property ->
            property.annotations
                    .filter { it is Slf4jLogger }
                    .forEach {
                        if (property is KMutableProperty<*>) {
                            property.setter.call(target, LoggerFactory.getLogger(loggerName))
                        }
                    }
        }
    }
}
