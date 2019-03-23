package com.pvasilev.uplabs.network

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Selector(val value: String, val attr: String)