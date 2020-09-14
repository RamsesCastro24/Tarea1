
package tap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TAP extends JFrame{

  private final JTextField txtFile; 
	private final JTextArea text; 
	private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;

	TAP(){
    	super("Prueba de Cifrado");
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
    	fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel( "Nombre de Archivo de texto:" );
        lblFile.setFont(new Font ("Calibri",Font.BOLD,18));
       lblFile.setForeground(Color.GRAY);
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
       saveJButton.addActionListener(new saveAccion());
       encryptJButton.addActionListener(new encryptAccion());     
        decryptJButton.addActionListener(new desencryptAccion() );
    }
        class txtAccion implements ActionListener{
    	
        @Override
        
          public void actionPerformed(ActionEvent event)
          {
          String codigo= text.getText();
                String File= txtFile.getText();
               
                Leer(File);
                
          }
          
           public void Leer(String txtFile) {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         archivo = new File ("src/tap/"+txtFile);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      Escribir(txtFile);
   }
    
    public void Escribir(String txtFile){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      archivo = new File("src/tap/"+txtFile);
        try { 
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                text.append(linea+"\n");
                linea = leer.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TAP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TAP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        }
              class encryptAccion implements ActionListener{
    	
        @Override
        
          public void actionPerformed(ActionEvent event)
          {
           String codigo= text.getText();
                
                String textoEncriptado = Encriptar(codigo);
                text.setText(textoEncriptado);
           
          }
              String Encriptar(String c){
        String codigo = c;
        char[] convertir = new char[20];
        char[] acomodar = new char[20];
        
        
        String cadena = codigo.trim();
        float ncadena = cadena.length();
        StringBuffer cadena2 = new StringBuffer();
        
        for (int i = 0; i < ncadena; i++) {
            char caracter = cadena.charAt(i);
            int ascii = (int)caracter+3;
            char codi = (char)ascii;
            convertir[i] = codi;
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)-.1); i++) {
            int num = (int)(ncadena)-i;
            acomodar[i] = convertir[num];
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)); i++) {
            int auxChar = Math.round((ncadena/2)) - i;
            
            char caracter = convertir[auxChar];
            int ascii = (int)caracter-1;
            char codi = (char)ascii;
            int aux = (int) Math.round((ncadena/2)-.1)+i;
            acomodar[aux] = codi;
        }
        
        for (int i = 0; i <= ncadena; i++) {
            cadena2 = cadena2.append(acomodar[i]);
    }
        
        String cadena3 = cadena2.toString();
        return cadena3;
        }
              }
    
              
           class desencryptAccion implements ActionListener{
    	
        @Override
        
          public void actionPerformed(ActionEvent event)
          {
              String codigo= text.getText();
                
                String textoDesencriptado = Desencriptar(codigo);
                text.setText(textoDesencriptado);
              
          }
          
           String Desencriptar(String c){
        String codigo = c;
        char[] convertir = new char[20];
        char[] acomodar = new char[20];
        int auxF = 0;
        
        String cadena = codigo.trim();
        float ncadena = cadena.length();
        StringBuffer cadena2 = new StringBuffer();
        
        for (int i = 0; i < ncadena; i++) {
            char caracter = cadena.charAt(i);
            int ascii = (int)caracter-3;
            char codi = (char)ascii;
            convertir[i] = codi;
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)); i++) {
            int num = (int)(ncadena)-i;
            char caracter = convertir[num];
            int ascii = (int)caracter+1;
            char codi = (char)ascii;
            acomodar[auxF] = codi;
            auxF++;
        }
        
        auxF = 0;
        for (int i = 1; i <= Math.round((ncadena/2)-.1); i++) {
            int auxChar = (int)Math.round((ncadena/2)-.1) - i;
            int aux = (int) Math.round((ncadena/2))+auxF;
            acomodar[aux] = convertir[auxChar];
            auxF++;
        }
        
        for (int i = 0; i <= ncadena; i++) {
            cadena2 = cadena2.append(acomodar[i]);
        }
        
        String cadena3 = cadena2.toString();
            return cadena3;
        }
          }    
              
              
              
     class saveAccion implements ActionListener{
    	
        @Override
        
          public void actionPerformed(ActionEvent e)
          {
           
        File f = null;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
    try{
        f = new File("src/tap/use.txt");
        w= new FileWriter(f);
        bw= new BufferedWriter (w);
        wr= new PrintWriter(bw);

        wr.write(text.getText());


        wr.close();
        bw.close();

    }catch (IOException event){
        JOptionPane.showMessageDialog(null, "Error"+ e);}
   
          }
    
    }
     
    
    
        

    
    
    public static void main(String[] args) {
       TAP ventana = new TAP(); 
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      ventana.setBounds(500, 300, 500, 300);
        
     
      ventana.setVisible(true); 
    }
    
}
