package it.nicus.kotlinboot

/**
 * Jackson needs nullable fields or default values to deserialise
 * TODO find a better way
 */
data class Greeting(val id: Long?, val content: String?)
