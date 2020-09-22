
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener {

    Vista view;
    Modelo model;

    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;
        this.view.saveJButton.addActionListener(this);
        view.saveJButton.setActionCommand("Accion_Guardar");

        this.view.encryptJButton.addActionListener(this);
        view.encryptJButton.setActionCommand("Accion_Encriptar");

        this.view.decryptJButton.addActionListener(this);
        view.decryptJButton.setActionCommand("Accion_Desencriptar");

        this.view.txtFile.addActionListener(this);
        view.txtFile.setActionCommand("Accion_Enter");

    }

    public void iniciar() {
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        view.setBounds(500, 300, 500, 300);
        view.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = view.text.getText();
        String File = view.txtFile.getText();
        String aux = e.getActionCommand();

        switch (aux) {
            case "Accion_Guardar":
                model.Guardar(codigo);

                break;
            case "Accion_Encriptar":

                String encrip = model.Encriptar(codigo);
                view.text.setText(encrip);
                break;

            case "Accion_Desencriptar":

                String desc = model.Desencriptar(codigo);
                view.text.setText(desc);
                break;

            case "Accion_Enter":
                model.Leer(File, view);

                break;

        }

        String s = view.text.getText();
        view.text.setText(s);

    }

}
