package modelo;

public class ClsFacturas {
    private String codigoProducto;
    private int cantidad;
    private float valorVenta;
    private float total;


    public ClsFacturas(String codigoProducto, int cantidad, float valorVenta) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.valorVenta = valorVenta;
        this.total = valorVenta * (float)cantidad;
    } 
    //Getters


    public String getCodigoProducto() {
        return codigoProducto;
    }


    public int getCantidad() {
        return cantidad;
    }


    public float getValorVenta() {
        return valorVenta;
    }


    public float getTotal() {
        return total;
    }

}