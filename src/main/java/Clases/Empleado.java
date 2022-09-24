package Clases;

import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private int idUsuario;
    private String nombre;
    private int dni;
    private int telefono;
    private Date fechaN;
    private Date fechaC;
    private String direccion;
    private String correoElectronico;
    private String Estado;

    public Empleado() {
    }

    public Empleado(int idEmpleado, int idUsuario, String nombre, int dni, int telefono, Date fechaN, Date fechaC, String direccion, String correoElectronico, String Estado) {
        this.idEmpleado = idEmpleado;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaN = fechaN;
        this.fechaC = fechaC;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.Estado = Estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
