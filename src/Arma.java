import java.util.List;

public class Arma extends Objeto {
    int dano;
    int vel_recarga;
    int cadencia;
    int capacidad;

    public Arma(String nombre, double p_compra, int dano, int vel_recarga, int cadencia, int capacidad) {
        super(nombre, p_compra);
        this.dano = dano;
        this.vel_recarga = vel_recarga;
        this.cadencia = cadencia;
        this.capacidad = capacidad;
    }

    public void inv_vendedor(List<Objeto> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
        System.out.print(this.nombre + " x " + cantidad.get(indice) + "s\td\t(" + this.p_compra + ")\n");
        System.out.println(" Daño Vel.Recarga Cadencia Capacidad");
        
        System.out.print(" " + repetir("|", dano) + repetir("-", 6 - dano) + "   ");
        System.out.print(repetir("|", vel_recarga) + repetir("-", 3 - vel_recarga) + "            ");
        System.out.print(repetir("|", cadencia) + repetir("-", 6 - cadencia) + "      ");
        System.out.print(repetir("|", capacidad) + repetir("-", 3 - capacidad) + " ");
        System.out.println();
    }

    public void inv_mejora() {
        System.out.println("Mejorar " + this.nombre);
        System.out.print("1. Daño " + repetir("|", dano) + repetir("-", 6 - dano) + "   ");
        System.out.printf("%.2f $\n", (10000 - 8000 * (1 - dano / 6.0)));
        System.out.print("2. Vel. Recarga " + repetir("|", vel_recarga) + repetir("-", 3 - vel_recarga) + "      ");
        System.out.printf("%.2f $\n", (10000 - 8000 * (1 - vel_recarga / 3.0)));
        System.out.print("3. Cadencia " + repetir("|", cadencia) + repetir("-", 6 - cadencia) + "   ");
        System.out.printf("%.2f $\n", (10000 - 8000 * (1 - cadencia / 6.0)));
        System.out.print("4. Capacidad " + repetir("|", capacidad) + repetir("-", 3 - capacidad) + "      ");
        System.out.printf("%.2f $\n", (10000 - 8000 * (1 - capacidad / 3.0)));
    }

    private String repetir(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
}