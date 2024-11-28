package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {

    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
        this.zona = new Zona();
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.zona = zona;
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = coordenada;
    }

    public Robot(Robot robotCopia) {
        zona = robotCopia.zona;
        orientacion = robotCopia.orientacion;
        coordenada = robotCopia.coordenada;
    }


    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void avanzar() {
        int nuevaCoordenadaX = coordenada.x();
        int nuevaCoordenadaY = coordenada.y();
        
        switch (orientacion) {
            case NORTE -> nuevaCoordenadaY++;
            case NORESTE -> { nuevaCoordenadaX++; nuevaCoordenadaY++; }
            case ESTE -> nuevaCoordenadaX++;
            case SURESTE -> { nuevaCoordenadaX++; nuevaCoordenadaY--; }
            case SUR -> nuevaCoordenadaY--;
            case SUROESTE -> { nuevaCoordenadaX--; nuevaCoordenadaY--; }
            case OESTE -> nuevaCoordenadaX--;
            case NOROESTE -> { nuevaCoordenadaX--; nuevaCoordenadaY++; }
        }
        
        Coordenada nuevaCoordenada = new Coordenada(nuevaCoordenadaX, nuevaCoordenadaY);
        coordenada = nuevaCoordenada;
    }

    public void girarALaDerecha() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
        };
    }

    public void girarALaIzquierda() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.NORTE;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, orientacion, coordenada);
    }

    @Override
    public String toString() {
        return String.format("[zona=%s, orientacion=%s, coordenada=%s]", zona, orientacion, coordenada);
    }
}

