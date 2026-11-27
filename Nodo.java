public class Nodo {
    String info;
    Nodo izq;
    Nodo der;

    public Nodo(String v) {
        this.info = v;
        this.izq = null;
        this.der = null;
    }
}