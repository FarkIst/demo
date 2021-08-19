package com.example

import io.micronaut.http.annotation.*
import com.example.Book
import java.util.*
import javax.inject.Inject

@Controller("/api/book")
class BookController{
@Inject
lateinit var bookRepository: BookRepository


@Get("/{name}")
fun name(@PathVariable name: String): Book{
    var book = bookRepository.findByName(name)
    return book
}

@Post("/save")
fun testpost(@Body book: Book): Book{
    //var book = Book(0, "Hello", "This is a sample book", 100)    
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