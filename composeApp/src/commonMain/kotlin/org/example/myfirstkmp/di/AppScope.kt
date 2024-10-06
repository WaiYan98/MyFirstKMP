package org.example.myfirstkmp.di

import me.tatarka.inject.annotations.Scope
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.PROPERTY_GETTER

@Scope
@Target(FUNCTION, CLASS, PROPERTY_GETTER)
annotation class AppScope {
}