package org.iesalandalus.programacion.robot.modelo;

public record Zona() {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    private static int ancho;
    private static int alto;


    public Zona(int ancho, int alto) {
        this();
        this.ancho = ancho;
        this.alto = alto;
    }

    public Zona() {
        ancho = ANCHO_MAXIMO;
        alto = ALTO_MAXIMO;
    }

    private int validarAncho (int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ALTO_MAXIMO) {
            throw new RobotExcepcion("El ancho tiene que estar dentro de la zona");
        }
        return ancho;
    }

    private int validarAlto (int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new RobotExcepcion("El alto tiene que estar dentro de la zona");
        }
        return alto;
    }

    public Coordenada getCentro() {
        int centroX = (ancho / 2);
        int centroY = (alto / 2);
        return new Coordenada(centroX,centroY);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada.x() >= 10 && coordenada.x() <= ANCHO_MAXIMO && coordenada.y() >= 10 && coordenada.y() < ALTO_MAXIMO) {
            return true;
        } else {
            return false;
        }
    }

    private boolean perteneceX(int x) {
        return (x >= 0) && (x <= ancho);
    }

    private boolean perteneceY(int y) {
        return (y >= 0) && (y <= alto);
    }
}
