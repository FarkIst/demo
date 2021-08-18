package com.example

import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/book")
class BookController{
@Inject
lateinit var bookRepository: BookRepository


    @Get("/{name}")
    fun getBook(@PathVariable name: String): Book {
        return bookRepository.findByName(name)
    }

@Post("/save")
fun create(@Body book: Book): Book{
    return bookRepository.save(book)
}

@Delete("delete/{name}")
fun delete(@PathVariable name: String){
    var book = bookRepository.findByName(name)
    return bookRepository.delete(book)
}

@Put("/update")
fun update(@Body book: Book): Book{
    return bookRepository.update(book)
}

}