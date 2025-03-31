import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor {
    List<Objeto> inv_tienda;
    List<Integer> cantidad;

    public Vendedor(List<Objeto> inv_tienda, List<Integer> cantidad) {
        this.inv_tienda = inv_tienda;
        this.cantidad = cantidad;
    }

    public void vender(Leon leon) {
        boolean bandera = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("inv_tienda: " + this.inv_tienda);
        
        while (!bandera) {
            int n = 1;
            boolean posee = false;
            System.out.println("---------- * TIENDA * ----------");
            System.out.println("Dinero: " + leon.dinero);

            for (Objeto item : this.inv_tienda) {
                System.out.print(n + ". ");
                item.inv_vendedor(this.inv_tienda, this.cantidad);
                n++;
            }
            System.out.println(n + ". Volver");
            System.out.print("Comprar: ");
            int opcion = scanner.nextInt();
            
            if (opcion == n) {
                bandera = true;
                break;
            } else {
                Objeto obj = this.inv_tienda.get(opcion - 1);
                int indice = this.inv_tienda.indexOf(obj);
                
                if (leon.dinero >= obj.p_compra) {
                    leon.dinero -= obj.p_compra;
                    
                    for (Objeto i : leon.inventario) {
                        if (i == obj) {
                            int leonIndice = leon.inventario.indexOf(i);
                            leon.cantidad.set(leonIndice, leon.cantidad.get(leonIndice) + 1);
                            this.cantidad.set(indice, this.cantidad.get(indice) - 1);
                            posee = true;
                            break;
                        }
                    }
                    
                    if (!posee) {
                        leon.inventario.add(obj);
                        leon.cantidad.add(1);
                        this.cantidad.set(indice, this.cantidad.get(indice) - 1);
                    }
                    
                    if (this.cantidad.get(indice) == 0) {
                        this.inv_tienda.remove(indice);
                        this.cantidad.remove(indice);
                    }
                } else {
                    System.out.println("\nDinero Insuficiente\n");
                }
            }
        }
    }

    public void mejorar(Leon leon) {
        boolean bandera = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!bandera) {
            System.out.println("------------ MEJORAR ------------");
            System.out.println("\nDinero: " + leon.dinero);
            int n = 1;
            
            for (Objeto i : leon.inventario) {
                if (i instanceof Arma) {
                    System.out.print(n + ". ");
                    i.inv_vendedor(leon.inventario, leon.cantidad);
                    System.out.println("\n");
                    n++;
                }
            }
            System.out.println(n + ". Volver");
            System.out.print("Selección: ");
            int opcion = scanner.nextInt();
            
            if (opcion == n) {
                bandera = true;
                break;
            }
            
            int num_arma = 0;
            for (Objeto i : leon.inventario) {
                if (i instanceof Arma) {
                    num_arma++;
                }
                if (i instanceof Arma && num_arma == opcion) {
                    Arma arma = (Arma) i;
                    int mejora = 0;
                    
                    while (mejora != 5) {
                        System.out.println("\n --------------- MEJORAR ---------------");
                        System.out.println("\nDinero: " + leon.dinero);
                        arma.inv_mejora();
                        System.out.println("5. Volver");
                        System.out.print("Selección: ");
                        mejora = scanner.nextInt();
                        
                        if (mejora == 5) {
                            break;
                        }
                        
                        switch (mejora) {
                            case 1:
                                if (arma.dano < 6) {
                                    double precio = Math.round(10000 - 8000 * (1 - arma.dano / 6.0) * 100) / 100.0;
                                    if (leon.dinero >= precio) {
                                        leon.dinero -= precio;
                                        arma.dano++;
                                    } else {
                                        System.out.println("Dinero insuficiente");
                                    }
                                } else {
                                    System.out.println("Daño máximo alcanzado");
                                }
                                break;
                            case 2:
                                if (arma.vel_recarga < 3) {
                                    double precio = Math.round(10000 - 8000 * (1 - arma.vel_recarga / 3.0) * 100) / 100.0;
                                    if (leon.dinero >= precio) {
                                        leon.dinero -= precio;
                                        arma.vel_recarga++;
                                    } else {
                                        System.out.println("Dinero insuficiente");
                                    }
                                } else {
                                    System.out.println("Vel. recarga máximo alcanzado");
                                }
                                break;
                            case 3:
                                if (arma.cadencia < 6) {
                                    double precio = Math.round(10000 - 8000 * (1 - arma.cadencia / 6.0) * 100) / 100.0;
                                    if (leon.dinero >= precio) {
                                        leon.dinero -= precio;
                                        arma.cadencia++;
                                    } else {
                                        System.out.println("Dinero insuficiente");
                                    }
                                } else {
                                    System.out.println("Cadencia máxima alcanzada");
                                }
                                break;
                            case 4:
                                if (arma.capacidad < 3) {
                                    double precio = Math.round(10000 - 8000 * (1 - arma.capacidad / 3.0) * 100) / 100.0;
                                    if (leon.dinero >= precio) {
                                        leon.dinero -= precio;
                                        arma.capacidad++;
                                    } else {
                                        System.out.println("Dinero insuficiente");
                                    }
                                } else {
                                    System.out.println("Capacidad máxima alcanzada");
                                }
                                break;
                        }
                    }
                }
            }
        }
    }
}