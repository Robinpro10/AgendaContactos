package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Contacto;
import modelo.ContactoDAO;
import vista.HomeAgenda;

public class ControladorContactos {

    private HomeAgenda vista;
    private ContactoDAO dao;
    private Contacto contacto;

    public ControladorContactos(HomeAgenda vista) {
        this.vista = vista;
        this.dao = new ContactoDAO();
        this.contacto = new Contacto();
        initListeners();
    }

    private void initListeners() {
        // Listener para el botón Agregar
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });

        // Listener para el botón Buscar
        vista.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarContacto();
            }
        });

        // Listener para el botón Actualizar
        vista.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarContacto();
            }
        });

        // Listener para el botón Eliminar
        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarContacto();
            }
        });

        // Listener para la tabla de contactos
        vista.getTblContactos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int fila = vista.getTblContactos().getSelectedRow();
                    if (fila != -1) {
                        String nombre = vista.getTblContactos().getValueAt(fila, 0).toString();
                        String sobreNombre = vista.getTblContactos().getValueAt(fila, 1).toString();
                        String correo = vista.getTblContactos().getValueAt(fila, 2).toString();
                        String celular = vista.getTblContactos().getValueAt(fila, 3).toString();

                        vista.getTxtNombre().setText(nombre);
                        vista.getTxtSobreNombre().setText(sobreNombre);
                        vista.getTxtCorreo().setText(correo);
                        vista.getTxtCelular().setText(celular);
                    }
                }
            }
        });

        // Inicializar la tabla con datos
        listarContactos();
    }

    private void agregarContacto() {
        String nombre = vista.getTxtNombre().getText();
        String sobreNombre = vista.getTxtSobreNombre().getText();
        String correo = vista.getTxtCorreo().getText();
        String celular = vista.getTxtCelular().getText();

        if (nombre.isEmpty() || sobreNombre.isEmpty() || correo.isEmpty() || celular.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben ser llenados.");
            return;
        }

        contacto.setNombre(nombre);
        contacto.setSobreNombre(sobreNombre);
        contacto.setCorreo(correo);
        contacto.setCelular(celular);

        if (dao.agregarContacto(contacto)) {
            JOptionPane.showMessageDialog(vista, "Contacto agregado con éxito.");
            listarContactos();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar el contacto.");
        }
    }

    private void buscarContacto() {
        String celular = vista.getTxtBuscar().getText();

        if (celular.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese un número de celular para buscar.");
            return;
        }

        contacto.setCelular(celular);

        if (dao.buscarContacto(contacto)) {
            DefaultTableModel modelo = (DefaultTableModel) vista.getTblContactos().getModel();
            modelo.setRowCount(0);
            modelo.addRow(new Object[]{
                contacto.getNombre(),
                contacto.getSobreNombre(),
                contacto.getCorreo(),
                contacto.getCelular()
            });
        } else {
            JOptionPane.showMessageDialog(vista, "Contacto no encontrado.");
        }
    }

    private void actualizarContacto() {
        String nombre = vista.getTxtNombre().getText();
        String sobreNombre = vista.getTxtSobreNombre().getText();
        String correo = vista.getTxtCorreo().getText();
        String celular = vista.getTxtCelular().getText();

        if (nombre.isEmpty() || sobreNombre.isEmpty() || correo.isEmpty() || celular.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben ser llenados.");
            return;
        }

        contacto.setNombre(nombre);
        contacto.setSobreNombre(sobreNombre);
        contacto.setCorreo(correo);
        contacto.setCelular(celular);

        if (dao.modificarContacto(contacto)) {
            JOptionPane.showMessageDialog(vista, "Contacto actualizado con éxito.");
            listarContactos();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el contacto.");
        }
    }

    private void eliminarContacto() {
        String celular = vista.getTxtCelular().getText();

        if (celular.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese un número de celular para eliminar.");
            return;
        }

        contacto.setCelular(celular);

        if (dao.eliminarContacto(contacto)) {
            JOptionPane.showMessageDialog(vista, "Contacto eliminado con éxito.");
            listarContactos();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al eliminar el contacto.");
        }
    }

    private void listarContactos() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblContactos().getModel();
        modelo.setRowCount(0);

        for (Contacto c : dao.obtenerRegistros()) {
            modelo.addRow(new Object[]{
                c.getNombre(),
                c.getSobreNombre(),
                c.getCorreo(),
                c.getCelular()
            });
        }
    }

    private void limpiarCampos() {
        vista.getTxtNombre().setText("");
        vista.getTxtSobreNombre().setText("");
        vista.getTxtCorreo().setText("");
        vista.getTxtCelular().setText("");
        vista.getTxtBuscar().setText("");
    }
}
