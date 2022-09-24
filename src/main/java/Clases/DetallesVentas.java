package Clases;

public class DetallesVentas {
    private int idDetalles;
    private int idComprobante;
    private int idProducto;
    private float precioUnidad;
    private int cantidad;

    public DetallesVentas() {
    }

    public DetallesVentas(int idDetalles, int idComprobante, int idProducto, float precioUnidad, int cantidad) {
        this.idDetalles = idDetalles;
        this.idComprobante = idComprobante;
        this.idProducto = idProducto;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
    }

    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
