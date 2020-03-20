package Controlador;

import Modelo.AlumnoBD;
import Modelo.Alumno;
import Vista.VCrearAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteActualizarALumno implements ActionListener {

    VCrearAlumnos crear;
    AlumnoBD basealumno;
    Alumno a;

    public OyenteActualizarALumno(VCrearAlumnos v) {
        this.crear= v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        basealumno = new AlumnoBD();
        basealumno.actualizarAlumno(crear.guardarAlumno());
        
        crear.limpiarCampos();
        crear.bloquearCampos();


    }

}


