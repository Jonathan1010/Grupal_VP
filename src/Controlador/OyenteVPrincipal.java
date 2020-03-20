/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.aleatorio;
import Vista.VCrearAlumnos;
import Vista.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OyenteVPrincipal implements ActionListener {
    VPrincipal ventana;
    
    public OyenteVPrincipal(VPrincipal ex){
           this.ventana=ex;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
       if (e.getSource()== ventana.getMiSalir()){
              System.exit(0);
      
        }
       if(e.getSource()==ventana.getMiAleatorio()){
                 new aleatorio();
               
            }
        if(e.getSource()==ventana.getMiCrear()){
                 new VCrearAlumnos();
               
            }
       
        
    }
    
}
