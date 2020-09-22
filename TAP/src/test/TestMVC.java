
package test;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class TestMVC {

    public static void main(String[] args) {
        Vista view = new Vista();
        Modelo mod = new Modelo();
        Controlador ctrl = new Controlador(view, mod);

        ctrl.iniciar();

    }

}
