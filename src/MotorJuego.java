import java.util.ArrayList;

public class MotorJuego {

    private String estado;
    private ArrayList<EntidadVideojuego> entidades;
    private int puntuacion;

    public MotorJuego() {
        estado = "MENU";
        entidades = new ArrayList<>();
        puntuacion = 0;
    }

    public void iniciarPartida() {
        estado = "JUGANDO";
        System.out.println("Partida iniciada");
    }

    public void pausar() {
        estado = "PAUSA";
        System.out.println("Juego pausado");
    }

    public void reanudar() {
        estado = "JUGANDO";
        System.out.println("Juego reanudado");
    }

    public void gameOver() {
        estado = "GAME_OVER";
        System.out.println("GAME OVER");
    }

    public void agregarEntidad(EntidadVideojuego entidad) {
        entidades.add(entidad);
        System.out.println(entidad.getNombre() + " añadida al juego");
    }

    public void eliminarEntidad(EntidadVideojuego entidad) {
        entidades.remove(entidad);
        System.out.println(entidad.getNombre() + " eliminada del juego");
    }

    public void actualizar() {

        System.out.println("\n--- ACTUALIZANDO JUEGO ---");

        for (EntidadVideojuego entidad : entidades) {

            System.out.println(
                    entidad.getNombre()
                            + " | Tipo: " + entidad.getTipo()
                            + " | Posicion: (" + entidad.getX()
                            + "," + entidad.getY() + ")"
                            + " | Vida: " + entidad.getVida());
        }

        System.out.println("--------------------------");
    }

    public void detectarColisiones() {

        EntidadVideojuego jugador = null;

        for (EntidadVideojuego entidad : entidades) {

            if (entidad.getTipo().equals("jugador")) {
                jugador = entidad;
                break;
            }
        }

        if (jugador == null) {
            return;
        }

        for (int i = 0; i < entidades.size(); i++) {

            EntidadVideojuego entidad = entidades.get(i);

            if (entidad == jugador) {
                continue;
            }

            if (jugador.getX() == entidad.getX()
                    && jugador.getY() == entidad.getY()) {

                if (entidad.getTipo().equals("enemigo")) {

                    jugador.setVida(jugador.getVida() - 20);

                    System.out.println(
                            "¡Colisión con enemigo! Vida restante: "
                                    + jugador.getVida());
                }

                if (entidad.getTipo().equals("moneda")) {

                    puntuacion += 10;

                    System.out.println(
                            "¡Moneda recogida! Puntos: "
                                    + puntuacion);

                    entidades.remove(i);
                    i--;
                }
            }
        }
    }

    public String guardarPartida() {

        EntidadVideojuego jugador = null;

        for (EntidadVideojuego entidad : entidades) {

            if (entidad.getTipo().equals("jugador")) {
                jugador = entidad;
                break;
            }
        }

        if (jugador == null) {
            return "No hay jugador";
        }

        return "{\n"
                + "estado: " + estado + ",\n"
                + "vida: " + jugador.getVida() + ",\n"
                + "x: " + jugador.getX() + ",\n"
                + "y: " + jugador.getY() + ",\n"
                + "puntos: " + puntuacion + "\n"
                + "}";
    }
}