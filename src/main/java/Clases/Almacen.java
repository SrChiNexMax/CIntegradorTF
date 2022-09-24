package Clases;

public class Almacen {
    private int idProducto;
    private int unidadesExistentes;
    private String suspendido;

    public Almacen() {
    }

    public Almacen(int idProducto, int unidadesExistentes, String suspendido) {
        this.idProducto = idProducto;
        this.unidadesExistentes = unidadesExistentes;
        this.suspendido = suspendido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }

    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }

    public String getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(String suspendido) {
        this.suspendido = suspendido;
    }
    
}
