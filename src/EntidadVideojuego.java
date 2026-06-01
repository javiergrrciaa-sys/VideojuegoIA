public class EntidadVideojuego {

    private String nombre;
    private String tipo;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int vida;
    private String imagen;

    public EntidadVideojuego(String nombre, String tipo, int x, int y,
                             int ancho, int alto, int vida, String imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vida = vida;
        this.imagen = imagen;
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getVida() {
        return vida;
    }

    public String getImagen() {
        return imagen;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}