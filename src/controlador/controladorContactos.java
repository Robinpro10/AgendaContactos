/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.contacto;
import modelo.contactoDAO;
import vista.HomeAgenda;

public abstract class controladorContactos implements ActionListener {

    contacto objetoContacto;
    contactoDAO objetoContactoDAO;

    DefaultTableModel tablaContacto = new DefaultTableModel();

    HomeAgenda FormularioHomeAgenda;
    String filtroCliente = "";

    public controladorContactos() {

        objetoContacto = new contacto();
        objetoContactoDAO = new contactoDAO();
        FormularioHomeAgenda = new HomeAgenda();

        DefaultTableModel tablaContacto = new DefaultTableModel();

        FormularioHomeAgenda.getBtnAgregar().addActionListener(this);
        FormularioHomeAgenda.getBtnActualizar().addActionListener(this);
        FormularioHomeAgenda.getBtnBuscar().addActionListener(this);
        FormularioHomeAgenda.getBtnEliminar().addActionListener(this);

    }

    public void mostrarContactos() {
        tablaContacto = (DefaultTableModel) FormularioHomeAgenda.getTblContactos().getModel();
        int fila = FormularioHomeAgenda.getTblContactos().getRowCount();
        while (tablaContacto.getRowCount() > 0) {
            tablaContacto.removeRow(0);
        }
        // Obtener registros y mostrarlos en la tabla
        objetoContactoDAO.obtenerRegistros().forEach(registro -> {
            tablaContacto.addRow(new Object[]{registro.getNombre(), registro.getSobreNombre(), registro.getCorreo(), registro.getCelular()});
        });
    }

    public void limpiarContactos() {
        FormularioHomeAgenda.getTxtBuscar().setText("");
    }

    public void limpiarAgregar() {
        FormularioHomeAgenda.getTxtNombre().setText("");
        FormularioHomeAgenda.getTxtSobreNombre().setText("");
        FormularioHomeAgenda.getTxtCorreo().setText("");
        FormularioHomeAgenda.getTxtCelular().setText("");
    }

    private boolean validarCamposAgrgarContacto(String nombre, String sobreNombre, String correo,String celular) {
        int band;
        band = 0;
        // Validar campo de Identificacion
        if (celular.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la celular.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(celular);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "la celular debe ser un número entero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
        if (nombre != null && !nombre.equals("")) {
            for (int i = 0; i < nombre.length(); i++) {
                char x = nombre.charAt(i);
                int z = x;
//                System.out.println("z: "+z);
//                System.out.println("x: "+x);
                if ((z == 32) || (z >= 65 && z <= 90) || (z >= 97 && z <= 122)) {
                    band = 1;
                } else {
                    band = 0;
                }
            }
            if (band == 0) {
                JOptionPane.showMessageDialog(FormularioHomeAgenda, "Nombre incorrecto, ingrese caracteres", "Espacio Nombre erroneo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(FormularioHomeAgenda, "Campo Nombre vacio, Por favor llenar el espacio", "Espacio Nombre vacio", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sobreNombre != null && !sobreNombre.equals("")) {
            for (int i = 0; i < sobreNombre.length(); i++) {
                char x = sobreNombre.charAt(i);
                int z = x;
                if ((z >= 64 && z <= 90) || (z >= 97 && z <= 122) || (z >= 45 && z <= 57)) {
                    band = 1;
                } else {
                    band = 0;
                }
            }
            if (band == 0) {
                JOptionPane.showMessageDialog(FormularioHomeAgenda, "sobreNombre incorrecto, ingrese caracteres", "Espacio sobreNombre erroneo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(FormularioHomeAgenda, "Campo sobreNombre vacio, Por favor llenar el espacio", "Espacio sobreNombre vacio", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (correo != null && !correo.equals("")) {
            for (int i = 0; i < correo.length(); i++) {
                char x = correo.charAt(i);
                int z = x;
                if (z == 35 || z == 32 || (z >= 45 && z <= 57) || (z >= 64 && z <= 90) || (z >= 97 && z <= 122)) {
                    band = 1;
                } else {
                    band = 0;
                }
            }
            if (band == 0) {
                JOptionPane.showMessageDialog(FormularioHomeAgenda, "correo incorrecto, ingrese caracteres", "Espacio correo erroneo", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(FormularioHomeAgenda, "Campo correo vacio, Por favor llenar el espacio", "Espacio correo vacio", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
