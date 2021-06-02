package me.oyurimatheus

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("me.oyurimatheus")
		.start()
}

