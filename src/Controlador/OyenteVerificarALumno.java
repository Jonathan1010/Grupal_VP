package Controlador;

import Modelo.Alumno;
import Modelo.AlumnoBD;
import Vista.VCrearAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class OyenteVerificarALumno implements ActionListener {

    VCrearAlumnos crear;
    AlumnoBD basealumno;
    Alumno a;

    public OyenteVerificarALumno(VCrearAlumnos v) {
        this.crear = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
             a = basealumno.buscarAlumno(crear.verificarAlumno());
        System.out.println(a.getCedula());
        } catch (Exception x) {
            System.out.println("Error"  + x);
        }
        
        if(a.getCedula() == null){
            crear.limpiarCampos();
            crear.desbloquearCampos();
        }else{
            crear.bloquearCampos();
            JOptionPane.showMessageDialog(crear, "El Alumno " + a.getNombre() + " " + a.getApellido() + " ya se encuentra registrado ");
        }
        
    }

}


