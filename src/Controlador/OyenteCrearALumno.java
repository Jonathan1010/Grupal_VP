package Controlador;

import Modelo.AlumnoBD;
import Modelo.Alumno;
import Vista.VCrearAlumnos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OyenteCrearALumno implements ActionListener {

    VCrearAlumnos crear;
    AlumnoBD basealumno;
    Alumno a;

    public OyenteCrearALumno(VCrearAlumnos v) {
        this.crear= v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //de la vista recibo un alumno
        a = crear.guardarAlumno();
        //en la base de datos envio un alumno a guardar
         basealumno.guardarAlumnoBD(a);
        //envio en la venta a limpiar los campos
        crear.limpiarCampos();
        crear.bloquearCampos();
        
//              System.out.println("objeto: "+vca.getName());

    }

}
