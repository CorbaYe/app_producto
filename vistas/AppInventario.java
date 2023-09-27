package vistas;

import javax.swing.JOptionPane;

import modelo.ClsProductos;

public class AppInventario {
    static ClsProductos [] productos = new ClsProductos[100];
    static int posicionesP = 0;
    static boolean sw;
    static int pos;

    public static void main(String[] args) {
        fntMenu(true);
    }

    private static void fntRegistrar(String codigo, String nombre, String descripcion, int stock, float valorCompra, float ganancia){
        productos[posicionesP] = new ClsProductos(codigo, nombre, descripcion, stock, valorCompra, ganancia);
        posicionesP++;
        JOptionPane.showMessageDialog(null,"Producto registrado","Registro",JOptionPane.INFORMATION_MESSAGE);
    }

    private static void fnt_consultar(String codigo){
        sw = false;
        pos = 0;
        for (int i = 0; i < posicionesP; i++) {
            if(codigo.equals(productos[i].getCodigo())){
                sw = true;
                pos = i;
                break;
            }
        }
        if(sw){
            JOptionPane.showInputDialog(null, "<<< CONSULTAR>>>\n\n" +
                    "Nombre: " + productos[pos].getNombre() + "\n" +
                    "Descripción: " + productos[pos].getDescripcion() + "\n" +
                    "Stock: " + productos[pos].getStock() + "\n" +
                    "Valor compra: " + productos[pos].getValorCompra() + "\n" + 
                    "Ganancia: " + productos[pos].getGanancia() + "\n" +
                    "Valor venta: "  + productos[pos].getValorVenta() + "\n" 
                );
        }

    }

    private static void fntSelector(int opcion){
        switch(opcion){
            case 1: String codigo = JOptionPane.showInputDialog(null, "Código");
                    String nombre = JOptionPane.showInputDialog(null, "Nombre");
                    String descripcion = JOptionPane.showInputDialog(null, "Descripción");
                    int stock = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock"));
                    float vcompra = Float.parseFloat(JOptionPane.showInputDialog(null, "Valor compra"));
                    float ganancia = Float.parseFloat(JOptionPane.showInputDialog(null, "Ganancia"));
                    fntRegistrar(codigo, nombre, descripcion, stock, vcompra, ganancia);
                    break;
            case 6: System.exit(0);
                break;
        }
    }

    private static void fntMenu(Boolean menu){
        do{
            int m = Integer.parseInt(
                JOptionPane.showInputDialog(null, "<<< MENÚ PRINCIPAL >>>\n\n" +
                    "1. Registrar producto\n" +
                    "2. Consultar producto\n" +
                    "3. Actualizar producto\n" +
                    "4. Registro compras\n" +
                    "5. Reportes\n" +
                    "6. Salir\n"
                ));
            
            fntSelector(m);

        }while(menu);
    }
}
