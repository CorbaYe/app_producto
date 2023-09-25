package modelo;

public class ClsProductos{
    private String codigo;
    private String nombre;
    private String descripcion;
    private int stock;
    private float valorCompra;
    private float ganancia;
    private float valorVenta;

    public ClsProductos(String codigo, String nombre, String descripcion, int stock, float valorCompra, float ganancia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.valorCompra = valorCompra;
        this.ganancia = ganancia;
        
        this.valorVenta = (valorCompra * ganancia) + valorCompra;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public float getGanancia() {
        return ganancia;
    }

    public float getValorVenta() {
        return valorVenta;
    }

    @Override
    public String toString() {
        return "ClsProductos [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock="
                + stock + ", valorCompra=" + valorCompra + ", ganancia=" + ganancia + ", valorVenta=" + valorVenta
                + "]";
    }
}
    
