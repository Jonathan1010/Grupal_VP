package Controlador;

import Modelo.AlumnoBD;
import Vista.VCrearAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteEliminarAlumno implements ActionListener {

    VCrearAlumnos crear;
    AlumnoBD d;

    public OyenteEliminarAlumno(VCrearAlumnos o) {

        this.crear = o;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        d.eliminar(crear.eliminarAlumno());

    }

}
