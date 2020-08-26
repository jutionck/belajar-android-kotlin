package com.example.first_android


fun main() {

    val mesinBesinKu: GasolineEngine = GasolineEngine()
    val mesinListrikKu = ElectricalEngine()

    val mobilBensinKu: Car = Car()
    mobilBensinKu.engine = mesinBesinKu
    mobilBensinKu.startEngine()

    val mobilListrikKu: Car = Car()
    mobilListrikKu.engine = mesinListrikKu
    mobilListrikKu.startEngine()

}


//depedency injecttion : Constructor Injection
// tidak ada batasan solusi hanya menggunakan Inheritance
// direkomendasikan menggunakan solusi interface, abstract

//setter injection
class Car() {

    lateinit var engine: Engine
    fun startEngine(){
        engine.start()
    }


}


interface Engine {

    fun start()

}

class GasolineEngine: Engine {

    override fun start() {
        println("Mesin Gasoline Nyala")
    }

}

class ElectricalEngine: Engine {

    override fun start() {
        println("Mesin Electrical Nyala")
    }
}

class DieselEngine: Engine {

    override fun start() {
        println("Mesin Diesel Nyala")
    }

}

class SteamEngine: Engine {

    override fun start() {
        println("Mesin Steam Nyala")
    }

}
