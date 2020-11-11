package com.skillbox.classesandinheritance

fun main() {
    var animal = object : Animal(44,22,23,"ee"){}
    animal.makeChild()
}