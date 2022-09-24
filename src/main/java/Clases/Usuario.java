package Clases;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private int clave;
    private String acceso;
    private String estado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, int clave, String acceso, String estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.acceso = acceso;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
