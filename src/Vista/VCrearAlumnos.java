package Vista;

import Controlador.OyenteActualizarALumno;
import Controlador.OyenteCrearALumno;
import Controlador.OyenteEliminarAlumno;
import Controlador.OyenteVerificarALumno;
import Modelo.Alumno;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VCrearAlumnos extends JFrame {

    JTextField Cedula = new JTextField(20);
    JTextField Nombres = new JTextField(20);
    JTextField Apellidos = new JTextField(20);
    JTextField Direccion = new JTextField(20);
    JTextField Telefono = new JTextField(20);
    JButton verificar = new JButton("Verificar");
    JButton Guardar;
    JButton Actualizar;
    Alumno alumno;

    public VCrearAlumnos() {
        super("DATOS ESTUDIANTE");
        setLocation(50, 50);
        //setSize(450,450);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.agregarComponentes();
        pack();
        setVisible(true);

    }

    private void agregarComponentes() {

        JPanel contenedor, panel, panelB;
        panel = new JPanel(new GridBagLayout());

        contenedor = new JPanel(new GridBagLayout());
        panelB = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints a = new GridBagConstraints();

        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 15, 10, 15);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Cedula"), c);
        c.gridx = 1;
        panel.add(Cedula, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Nombres"), c);
        c.gridx = 1;
        panel.add(Nombres, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Apellidos"), c);
        c.gridx = 1;
        panel.add(Apellidos, c);
        c.gridx = 0;
        c.gridy = 3;

        c.gridx = 0;
        c.gridy = 4;
        c.gridy = 5;
        panel.add(new JLabel("Telefono"), c);
        c.gridx = 1;
        panel.add(Telefono, c);

        //verificar
        c.gridx = 3;
        c.gridy = 6;
        panel.add(verificar, c);

        Guardar = new JButton("GUARDAR");
        Guardar.addActionListener(new OyenteCrearALumno(this));
        bloquearCampos();
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.addActionListener(new OyenteEliminarAlumno(this));
        JButton Actualizar = new JButton("ACTUALIZAR");
        Actualizar.addActionListener(new OyenteActualizarALumno(this));
        
        
        
        verificar.addActionListener(new OyenteVerificarALumno(this));
        Actualizar.addActionListener(new OyenteActualizarALumno(this));
        panelB.add(Guardar);
        panelB.add(btnEliminar);
        panelB.add(Actualizar);
        a.gridx = 0;
        a.gridy = 0;
        contenedor.add(panel, a);
        a.gridy = 1;
        contenedor.add(panelB, a);
        setContentPane(contenedor);
    }

    public Alumno guardarAlumno() {
        alumno = new Alumno();
        alumno.setNombre(Nombres.getText());
        alumno.setApellido(Apellidos.getText());
        alumno.setTeléfono(Telefono.getText());
        alumno.setCedula(Cedula.getText());

        return alumno;

    }

    public void limpiarCampos() {

        Cedula.setText("");
        Nombres.setText("");
        Apellidos.setText("");
        Telefono.setText("");

    }

    public String eliminarAlumno() {
        return Cedula.getText();

    }

    //falta poner codigo en el metodo 
    public String verificarAlumno() {
        return Cedula.getText();
    }

    //bloquear  
    public void bloquearCampos() {
        Nombres.setEditable(false);
        Apellidos.setEditable(false);
        Telefono.setEditable(false);
        Nombres.setEditable(false);

        Guardar.setEnabled(false);
    }

    public void desbloquearCampos() {
        Nombres.setEditable(true);
        Apellidos.setEditable(true);
        Telefono.setEditable(true);
        Nombres.setEditable(true);

        Guardar.setEnabled(true);
    }

//boton crear desbloquear true 
//boton verificar bloquear false 
}
