
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista extends JFrame {

    public JTextField txtFile;
    public JTextArea text;
    public JButton encryptJButton;
    public JButton decryptJButton;
    public JButton saveJButton;

    public Vista() {
        super("Prueba de Cifrado");
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel("Nombre de Archivo de texto:");
        lblFile.setFont(new Font("Calibri", Font.BOLD, 18));
        lblFile.setForeground(Color.GRAY);
        fileJPanel.add(lblFile);
        txtFile = new JTextField(20);
        fileJPanel.add(txtFile);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10, 15);
        add(text, BorderLayout.CENTER);

        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new BorderLayout());
        encryptJButton = new JButton("encrypt");
        buttonJPanel.add(encryptJButton, BorderLayout.NORTH);

        decryptJButton = new JButton("decrypt");
        buttonJPanel.add(decryptJButton, BorderLayout.CENTER);

        saveJButton = new JButton("Guardar");
        buttonJPanel.add(saveJButton, BorderLayout.SOUTH);
        add(buttonJPanel, BorderLayout.EAST);

    }
}
