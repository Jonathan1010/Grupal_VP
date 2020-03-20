/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.OyenteVPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VPrincipal {
    JFrame f=new JFrame();
  
    private  JMenuBar jmb=new JMenuBar();
    private  JMenu menu1;
    private JMenuItem miCrear,miAleatorio,miSalir;

    public JMenuItem getMiCrear() {
        return miCrear;
    }

    public JMenuItem getMiAleatorio() {
        return miAleatorio;
    }

    public JMenuItem getMiSalir() {
        return miSalir;
    }

   
     public VPrincipal(){
            f.setTitle("Ventana Principal");
	    f.setSize(500,450);
	    f.setLocation(200,200);
            iniciarComponentes();
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     } 
     
     private void iniciarComponentes(){
     
          f.setJMenuBar(jmb);
          menu1=new JMenu("Alumnos");
          jmb.add(menu1);
        
        
         miCrear=new JMenuItem("Crear ALumnos");
         miCrear.addActionListener(new OyenteVPrincipal(this));
         menu1.add(miCrear);
         
         miAleatorio=new JMenuItem("Aleatorio ALumnos");
          miAleatorio.addActionListener(new OyenteVPrincipal(this));
         menu1.add(miAleatorio);
         
         miSalir=new JMenuItem("Salir");
          miSalir.addActionListener(new OyenteVPrincipal(this));
         menu1.add(miSalir);
     
     }
     
      
    
    
     
     
}
