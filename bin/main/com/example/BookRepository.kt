package com.example

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.*
import io.micronaut.data.model.*
import io.micronaut.data.repository.CrudRepository
import com.example.Book

@Repository 
interface BookRepository : CrudRepository<Book, Long> { 
    @Executable
    fun find(name: String): Book

    fun findByName(name: String): Book

    fun findByPrice(price: Int): Book

    fun save(entity: Book): Book

    fun update(book: Book): Book

    fun updateByName(name: String, description: String, price: Int)

    fun delete(name: String)
}