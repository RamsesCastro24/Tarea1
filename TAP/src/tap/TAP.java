
package tap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TAP extends JFrame{

  private final JTextField txtFile; // displays file
	private final JTextArea text; // displays file
	private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;

	TAP(){
    	super("Testing cipher");
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
    	fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel( "Archivo de texto/cifrado:" );
        fileJPanel.add(lblFile);
        txtFile = new JTextField(20);
        fileJPanel.add(txtFile);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10,15);
    	add(text, BorderLayout.CENTER);
        
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new BorderLayout());
        encryptJButton = new JButton("encrypt");
    	buttonJPanel.add(encryptJButton, BorderLayout.NORTH);
    	decryptJButton = new JButton("decrypt"	);
    	buttonJPanel.add(decryptJButton, BorderLayout.CENTER);
    	saveJButton = new JButton("Guardar");
    	buttonJPanel.add(saveJButton, BorderLayout.SOUTH);
        add(buttonJPanel, BorderLayout.EAST);
            
        txtFile.addActionListener(new txtAccion());
    }
    
    class txtAccion implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
          	text.setText(event.getActionCommand());
          }
    }
    
    
    
    
    
    
    public static void main(String[] args) {
       TAP ventana = new TAP(); 
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      ventana.setBounds(700, 300, 500, 300);
        
     
      ventana.setVisible(true); 
    }
    
}
