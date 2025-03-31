import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Objeto granada = new Objeto("Granada", 2000);
        Objeto colgante = new Objeto("Colgante", 2500);
        Arma magnum = new Arma("Magnum", 5500, 5, 2, 1, 3);
        Arma escopeta = new Arma("Escopeta", 3200, 4, 1, 1, 4);
        Arma pistola = new Arma("Pistola", 4000, 4, 2, 2, 3);
        Objeto spray = new Objeto("Spray", 2000);

        List<Objeto> inventario = new ArrayList<>();
        List<Integer> cantidad = new ArrayList<>();
        inventario.add(spray);
        inventario.add(pistola);
        inventario.add(magnum);
        cantidad.add(4);
        cantidad.add(3);
        cantidad.add(2);

        List<Objeto> inv_tienda = new ArrayList<>();
        List<Integer> cant_tienda = new ArrayList<>();
        inv_tienda.add(granada);
        inv_tienda.add(colgante);
        inv_tienda.add(magnum);
        inv_tienda.add(escopeta);
        inv_tienda.add(spray);
        cant_tienda.add(3);
        cant_tienda.add(2);
        cant_tienda.add(2);
        cant_tienda.add(1);
        cant_tienda.add(3);

        Vendedor vendedor = new Vendedor(inv_tienda, cant_tienda);
        Leon leon = new Leon(inventario, cantidad, 600000);
        tiendaVendedor(vendedor, leon);
    }

    public static void tiendaVendedor(Vendedor vendedor, Leon leon) {
        Scanner scanner = new Scanner(System.in);
        int seleccion = 0;
        
        while (seleccion != 4) {
            System.out.println("\n -------------- TIENDA --------------");
            System.out.println("[ 1. Comprar] [ 2. Vender] [ 3. Mejorar]");
            System.out.println(" [ 4. Salir] ");
            System.out.print("Selección: ");
            seleccion = scanner.nextInt();
            
            switch (seleccion) {
                case 1:
                    vendedor.vender(leon);
                    break;
                case 2:
                    leon.vender(vendedor);
                    break;
                case 3:
                    vendedor.mejorar(leon);
                    break;
                case 4:
                    System.out.println("Saliendo de la tienda...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}