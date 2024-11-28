package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {
    private Robot robot;

    public ControladorRobot(Robot robot) {
        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        // Evitar aliasing creando una copia del robot
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        // Devolver una copia para evitar aliasing
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws RobotExcepcion {
        switch (Character.toUpperCase(comando)) {
            case 'A':
                robot.avanzar();
                break;
            case 'D':
                robot.girarALaDerecha();
                break;
            case 'I':
                robot.girarALaIzquierda();
                break;
            default:
                throw new RobotExcepcion("Comando desconocido.");
        }
    }
}