

fun main(){
    r2d2v1() // FUNCIONA CON VALORES PREDEFINIDOS
    r2d2v2() // FUNCIONA CON VALORES INGRESADOS POR EL USUARIO
}
/*
 * Esta función solo le va a pasar los parametros a la función que mueve el robot
 */
fun r2d2v1() {
    mover(10, 5, -2)
    mover(0, 0, 0)
    mover()
    mover(-10, -5, 2)
    mover(-10, -5, 2, 4, -8)
}
 /*
  * Función que se encarga de procesar los movimientos y evaluar la direccion en la que está mirando (por alguna razón
  * siempre gira 90º...)
  */
fun mover(vararg movs: Int) {
    var posx = 0
    var posy = 0
    var direccion = 1
    for (movimiento in movs) {
        when (direccion) {
            1 -> {
                posy += movimiento
                direccion = 2
            }
            2 -> {
                posx -= movimiento
                direccion = 3
            }
            3 -> {
                posy -= movimiento
                direccion = 4
            }
            4 -> {
                posx += movimiento
                direccion = 1
            }
        }
    }
    when (direccion) {
        1 -> {
            println("X: $posx, Y: $posy, direction: POSITIVE Y")
        }
        2 -> {
            println("X: $posx, Y: $posy, direction: NEGATIVE X")
        }
        3 -> {
            println("X: $posx, Y: $posy, direction: NEGATIVE Y")
        }
        4 -> {
            println("X: $posx, Y: $posy, direction: POSITIVE X")
        }
    }
}

fun r2d2v2(){
    print("Ingrese una lista de movimiento con el siguiente formato (5, -9, 25) -> ")
    val movs = readln().split(", ")
    var posx = 0
    var posy = 0
    var direccion = 1
    try {
        for (movimiento in movs){
            when (direccion) {
                1 -> {
                    posy += movimiento.toInt()
                    direccion = 2
                }
                2 -> {
                    posx -= movimiento.toInt()
                    direccion = 3
                }
                3 -> {
                    posy -= movimiento.toInt()
                    direccion = 4
                }
                4 -> {
                    posx += movimiento.toInt()
                    direccion = 1
                }
            }
        }
        when (direccion) {
            1 -> {
                println("X: $posx, Y: $posy, direction: POSITIVE Y")
            }
            2 -> {
                println("X: $posx, Y: $posy, direction: NEGATIVE X")
            }
            3 -> {
                println("X: $posx, Y: $posy, direction: NEGATIVE Y")
            }
            4 -> {
                println("X: $posx, Y: $posy, direction: POSITIVE X")
            }
        }
    }
    catch (_:NumberFormatException){
        println("X: $posx, Y: $posy, direction: POSITIVE Y")
    }

}