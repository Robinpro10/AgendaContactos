
package modelo;

public class Contacto {
    private String nombre;
    private String sobreNombre;
    private String correo;
    private String celular;

    public Contacto() {
    }

    public Contacto(String nombre, String sobreNombre, String correo, String celular) {
        this.nombre = nombre;
        this.sobreNombre = sobreNombre;
        this.correo = correo;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSobreNombre() {
        return sobreNombre;
    }

    public void setSobreNombre(String sobreNombre) {
        this.sobreNombre = sobreNombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


}
