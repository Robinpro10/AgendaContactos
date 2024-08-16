/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AgendaContactos;

import controlador.ControladorContactos;
import modelo.ContactoDAO;
import vista.HomeAgenda;

public class AgendaContactos {

    public static void main(String[] args) {
        HomeAgenda vista = new HomeAgenda();
        ContactoDAO modelo = new ContactoDAO();
        ControladorContactos controlador = new ControladorContactos(vista);
        vista.setVisible(true);
    }

}
