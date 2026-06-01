public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();

        GestorEntradas gestor = new GestorEntradas();

        EntidadVideojuego jugador =
                new EntidadVideojuego(
                        "Jugador",
                        "jugador",
                        0,
                        0,
                        1,
                        1,
                        100,
                        "nave.png");

        EntidadVideojuego enemigo =
                new EntidadVideojuego(
                        "Enemigo",
                        "enemigo",
                        2,
                        0,
                        1,
                        1,
                        50,
                        "enemigo.png");

        EntidadVideojuego moneda =
                new EntidadVideojuego(
                        "Moneda",
                        "moneda",
                        1,
                        0,
                        1,
                        1,
                        1,
                        "moneda.png");

        motor.agregarEntidad(jugador);
        motor.agregarEntidad(enemigo);
        motor.agregarEntidad(moneda);

        motor.iniciarPartida();

        motor.actualizar();

        gestor.moverJugador(jugador, "DERECHA");

        motor.actualizar();

        motor.detectarColisiones();

        gestor.moverJugador(jugador, "DERECHA");

        motor.actualizar();

        motor.detectarColisiones();

        System.out.println("\nGUARDADO RAPIDO:");
        System.out.println(motor.guardarPartida());

        motor.pausar();

        motor.reanudar();

        motor.gameOver();
    }
}
