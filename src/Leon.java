import java.util.List;
import java.util.Scanner;

public class Leon {
    List<Objeto> inventario;
    List<Integer> cantidad;
    double dinero;

    public Leon(List<Objeto> inventario, List<Integer> cantidad, double dinero) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.dinero = dinero;
    }

    public void vender(Vendedor vendedor) {
        boolean bandera = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!bandera) {
            boolean posee = false;
            int n = 1;
            System.out.println("-------------- * INVENTARIO * --------------");
            System.out.println("Dinero: " + this.dinero);
            
            for (Objeto item : this.inventario) {
                System.out.print(n + ". ");
                item.inv_leon(this.inventario, this.cantidad);
                n++;
            }
            System.out.println(n + ". Volver");
            System.out.print("Vender: ");
            int opcion = scanner.nextInt();
            
            if (opcion == n) {
                bandera = true;
                break;
            } else {
                Objeto obj = this.inventario.get(opcion - 1);
                int indice = this.inventario.indexOf(obj);
                this.dinero += obj.p_venta;
                this.cantidad.set(indice, this.cantidad.get(indice) - 1);
                
                for (Objeto i : vendedor.inv_tienda) {
                    if (i == obj) {
                        int vendedorIndice = vendedor.inv_tienda.indexOf(i);
                        vendedor.cantidad.set(vendedorIndice, vendedor.cantidad.get(vendedorIndice) + 1);
                        posee = true;
                        break;
                    }
                }
                
                if (!posee) {
                    vendedor.inv_tienda.add(obj);
                    vendedor.cantidad.add(1);
                }
                
                if (this.cantidad.get(indice) == 0) {
                    this.inventario.remove(indice);
                    this.cantidad.remove(indice);
                }
            }
        }
    }
}