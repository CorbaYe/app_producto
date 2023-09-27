package modelo;

public class ClsFacturas {
    private String codigoProducto;
    private String cantidad;
    private float valorVenta;
    private float total;


    public ClsFacturas(String codigoProducto, String cantidad, float valorVenta) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorVenta = valorVenta;
    } 
}