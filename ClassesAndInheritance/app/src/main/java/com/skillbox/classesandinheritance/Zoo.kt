package com.skillbox.classesandinheritance

class Zoo {
    var animalList: MutableList<Animal> = mutableListOf(
            Bird(10,4,5,"bird1"),
            Bird(10,4,5,"bird2"),
            Bird(10,4,5,"bird3"),
            Bird(10,4,5,"bird4"),
            Bird(10,4,5,"bird5"),
            Fish(5,3,2,"fish1"),
            Fish(5,3,2,"fish2"),
            Fish(5,3,2,"fish3"),
            Dog(20,8,15,"dog1"),
            Dog(20,8,15,"dog2"),
            object : Animal(5,5,5,"animal1"){},
            object : Animal(5,5,5,"animal2"){})
}