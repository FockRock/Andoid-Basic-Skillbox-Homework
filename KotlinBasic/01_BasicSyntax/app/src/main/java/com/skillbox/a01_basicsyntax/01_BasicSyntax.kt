package com.skillbox.a01_basicsyntax

fun main() {

    val firstName = "Nick"
    val secondName = "Smirnov"
    var height = 181
    val weight = 92.2F
    val isChild: Boolean = height < 150 && weight < 40

    var info = """
        My name is $firstName
        My second name is $secondName
        My height - $height sm
        My weight is $weight kg
        I am ${if(isChild) "" else "not"} child.
    """
    println(info)

    height += 10
    info = """
        Information Upgraded!        
        
        My name is $firstName
        My second name is $secondName
        My NEW height - $height sm
        My weight is $weight kg
        I am ${if(isChild) "" else "not"} child.
    """

    println(info)
}