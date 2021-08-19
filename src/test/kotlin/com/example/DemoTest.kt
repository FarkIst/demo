package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var bookRepository: BookRepository

    @Test
    fun testItWorks() {
        assertTrue(application.isRunning)
    }

    @Test
    fun crudTest(){
        assertNotNull(bookRepository)

        //Create
        var book = Book(0, "Inferno", "Dante Alighieri's Inferno", 666)
        bookRepository.save(book)

        val name = book.name
        assertNotNull(name)

        //Get
        var newBook = bookRepository.findByName("Inferno")
        assertNotNull(newBook)

        //Update
        bookRepository.updateByName("Inferno", "Someone elses Inferno", 96 )
        var updated = bookRepository.findByName("Inferno")
        assertEquals("Someone elses Inferno", updated.description)
        assertEquals(96, updated.price)

        //Delete
        bookRepository.delete("Inferno")
        assertEquals(0, bookRepository.count())
    }
}
