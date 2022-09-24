package Clases;

import java.sql.Date;

public class Venta {
    private int idComprobante;
    private String tipoComprobante;
    private int idCliente;
    private int idUsuario;
    private Date fechaVenta;
    private float importe;
    private String suspendido;
    private String facturado;
    private String liquidado;

    public Venta() {
    }

    public Venta(int idComprobante, String tipoComprobante, int idCliente, int idUsuario, Date fechaVenta, float importe, String suspendido, String facturado, String liquidado) {
        this.idComprobante = idComprobante;
        this.tipoComprobante = tipoComprobante;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.fechaVenta = fechaVenta;
        this.importe = importe;
        this.suspendido = suspendido;
        this.facturado = facturado;
        this.liquidado = liquidado;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(String suspendido) {
        this.suspendido = suspendido;
    }

    public String getFacturado() {
        return facturado;
    }

    public void setFacturado(String facturado) {
        this.facturado = facturado;
    }

    public String getLiquidado() {
        return liquidado;
    }

    public void setLiquidado(String liquidado) {
        this.liquidado = liquidado;
    }
    
}
