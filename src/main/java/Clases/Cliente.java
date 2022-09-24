package Clases;

public class Cliente {
    private int idCliente;
    private long DNI_RUC;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int idCliente, long DNI_RUC, String nombre, int telefono, String direccion) {
        this.idCliente = idCliente;
        this.DNI_RUC = DNI_RUC;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public long getDNI_RUC() {
        return DNI_RUC;
    }

    public void setDNI_RUC(long DNI_RUC) {
        this.DNI_RUC = DNI_RUC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
