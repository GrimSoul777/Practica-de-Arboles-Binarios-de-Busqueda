public class ABB {
    Nodo R;

    public ABB() {
        this.R = null;
    }

    public Nodo Insertar(Nodo N, String v){
        if (N == null) {
            N = new Nodo(v);
        } else if (v.compareToIgnoreCase(N.info) < 0) {
            N.izq = Insertar(N.izq, v);
        } else {
            N.der = Insertar(N.der, v);
        }

        return N;
    }

    public void Eliminar(Nodo N, String v){

    }

    public void Modificar(Nodo N, String v){

    }

    public int Buscar(Nodo N, String v, int nivel){
        if (N == null) {
            return -1;
        } else if (v.equalsIgnoreCase(N.info)) {
            return nivel;
        } else if (v.compareToIgnoreCase(N.info) < 0) {
            return Buscar(N.izq, v, nivel + 1);
        } else {
            return Buscar(N.der, v, nivel + 1);
        }
    }

    public void PreOrder(Nodo N){
        if (N != null) {
            System.out.println(N.info);
            PreOrder(N.izq);
            PreOrder(N.der);
        }
    }

    public void InOrder(Nodo N){
        if (N != null) {
            InOrder(N.izq);
            System.out.println(N.info);
            InOrder(N.der);
        }
    }

    public void PostOrder(Nodo N){
        if (N != null) {
            PostOrder(N.izq);
            PostOrder(N.der);
            System.out.println(N.info);
        }
    }

    public void Liberar(Nodo N){
        if (N != null) {
            Liberar(N.izq);
            Liberar(N.der);
            N.izq=N.der=null;
        }
    }
}