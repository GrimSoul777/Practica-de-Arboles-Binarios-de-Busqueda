public class ABB {
    Nodo R;

    public ABB() {
        this.R = null;
    }

    public void Insertar(Nodo N, String v){

    }

    public void Eliminar(Nodo N, String v){

    }

    public void Modificar(Nodo N, String v){

    }

    public void Buscar(Nodo N, String v){

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