package org.newbalancer.mockexpansion

import com.fasterxml.jackson.databind.ObjectMapper
import org.mockito.BDDMockito
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.nio.file.Files

/**
 * MockExpansion Util Class
 */
object MockExpansionUtil {

    /**
     * read json file to class
     */
    fun <T : Any> readJsonFileToClass(jsonFileName: String, ofClass: Class<T>): T? {

        val resource: File = ClassPathResource(jsonFileName).file

        val text = String(Files.readAllBytes(resource.toPath()))

        val objectMapper = ObjectMapper()

        return objectMapper.readValue(text, ofClass)
    }

    /**
     * BDDMockito any checked
     */
    fun <T> any(): T {
        BDDMockito.any<T>()
        return uninitialized()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> uninitialized(): T = null as T
}