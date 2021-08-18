package com.example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Book(@Id
                @GeneratedValue
                var id: Long,
                var name: String,
                var description: String,
                var price: Int)