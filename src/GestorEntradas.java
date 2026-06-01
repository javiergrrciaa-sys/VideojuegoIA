public class GestorEntradas {

    public void moverJugador(EntidadVideojuego jugador,
                             String direccion) {

        switch (direccion.toUpperCase()) {

            case "ARRIBA":
                jugador.mover(0, -1);
                break;

            case "ABAJO":
                jugador.mover(0, 1);
                break;

            case "IZQUIERDA":
                jugador.mover(-1, 0);
                break;

            case "DERECHA":
                jugador.mover(1, 0);
                break;

            default:
                System.out.println("Direccion no valida");
        }

        System.out.println(
                "Jugador movido hacia "
                        + direccion);
    }
}