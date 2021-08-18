package com.example

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.*
import io.micronaut.data.repository.CrudRepository


@Repository
interface BookRepository : CrudRepository<Book, Long> { 
    @Executable
    fun find(id: Id): Book

    fun findByName(name: String): Book

    fun save(entity: Book): Book

    fun update(book: Book): Book

    fun updateByName(name: String, description: String, price: Int)

    fun delete(name: String)
}