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

    private static void fntConsultar(String codigo){
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
            JOptionPane.showMessageDialog(null, "<<< CONSULTAR>>>\n\n" +
                    "Nombre: " + productos[pos].getNombre() + "\n" +
                    "Descripción: " + productos[pos].getDescripcion() + "\n" +
                    "Stock: " + productos[pos].getStock() + "\n" +
                    "Valor compra: " + productos[pos].getValorCompra() + "\n" + 
                    "Ganancia (%): " + productos[pos].getGanancia() + "\n" +
                    "Valor venta: "  + productos[pos].getValorVenta() + "\n" 
                );
        }else{
            JOptionPane.showMessageDialog(null, "No se encontraron registros");
        }
    }
    
    private static void fntActualizar(String codigo){
        sw = false;
        pos = 0;
        for(int i = 0; i < posicionesP; i++){
            if(codigo.equals(productos[i].getCodigo())){
                sw = true;
                pos = i;
                break;
            }
        }
        if(sw){
            boolean salir = true;
            do{
                int opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "<<< MENÚ ACTUALIZAR >>>\n\n" +
                        "1. Actualizar nombre\n" +
                        "2. Actualizar descripción\n" +
                        "3. Salir\n"
                    ));
                switch(opcion){
                    case 1: String nombre = JOptionPane.showInputDialog(null, "Nombre");
                            productos[pos].setNombre(nombre);
                            JOptionPane.showMessageDialog(null, "Nombre del producto actualizado","ACTUALIZAR",JOptionPane.INFORMATION_MESSAGE);
                            break;
                    case 2: String descripcion = JOptionPane.showInputDialog(null, "Descripción");
                            productos[pos].setDescripcion(descripcion);
                            JOptionPane.showMessageDialog(null, "Descripción del producto actualizada","ACTUALIZAR",JOptionPane.INFORMATION_MESSAGE);
                            break;
                    case 3: salir = false;
                            break;
                    default: JOptionPane.showMessageDialog(null, "Opción no disponible","ACTUALIZAR",JOptionPane.WARNING_MESSAGE);
                }
            }while(salir);
        }else{
            JOptionPane.showMessageDialog(null,"No se encontraron registros","ACTUALIZAR", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void fntSelector(int opcion){
        String codigo = "";
        String nombre = "";
        String descripcion = "";
        int stock = 0;
        float vcompra = 0;
        float ganancia = 0;

        switch(opcion){
            case 1: codigo = JOptionPane.showInputDialog(null, "Código");
                    nombre = JOptionPane.showInputDialog(null, "Nombre");
                    descripcion = JOptionPane.showInputDialog(null, "Descripción");
                    stock = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock"));
                    vcompra = Float.parseFloat(JOptionPane.showInputDialog(null, "Valor compra"));
                    ganancia = Float.parseFloat(JOptionPane.showInputDialog(null, "Ganancia"));
                    fntRegistrar(codigo, nombre, descripcion, stock, vcompra, ganancia);
                    break;
            case 2: codigo = JOptionPane.showInputDialog(null, "Código");
                    fntConsultar(codigo);
                    break;
            case 3: codigo = JOptionPane.showInputDialog(null, "Código");
                    fntActualizar(codigo);
                    break;
            case 6: System.exit(0);
                break;
            default: JOptionPane.showMessageDialog(null,"Opción no disponible");
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
