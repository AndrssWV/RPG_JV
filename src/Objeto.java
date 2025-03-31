import java.util.List;

public class Objeto {
    String nombre;
    double p_compra;
    double p_venta;
    int pos;

    public Objeto(String nombre, double p_compra) {
        this.nombre = nombre;
        this.p_compra = p_compra;
        this.p_venta = p_compra * 1.25;
        this.pos = 0;
    }

    public void inv_vendedor(List<Objeto> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
        System.out.println(this.nombre + " x " + cantidad.get(indice) + " (" + this.p_compra + ")");
    }

    public void inv_leon(List<Objeto> inventario, List<Integer> cantidad) {
        int indice = inventario.indexOf(this);
        System.out.println(this.nombre + " x " + cantidad.get(indice) + " (" + this.p_venta + ")");
    }
}

