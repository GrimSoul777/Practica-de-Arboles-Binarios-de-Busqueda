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

    public Eliminar(Nodo N, String v){
        Nodo E = BuscarNodo(N, v);
        if (E == null) {
            return null;
        }

        //dos hijos
        if (E.izq != null && E.der !=null){  
            Nodo PT = E;
            Nodo T = E.izq;
            while (T.der != null){
                PT= T;
                T= T.der;
            }
            String temp= E.info;
            E.info= T.info;
            T.info= temp;
            //T tiene mx un hijo a la izq
            if(PT == E){
                PT.izq = T.izq;
            } else {
                PT.der= T.izq;
            }
            T.izq= null;
            return T;   
        }

        //sin hijos o con un hijo
        Nodo hijo = (E.izq!= null)? E.izq:E.der;    //null si es hoja
        if (E== R){
            R= hijo;
        } else {
            Nodo P= BuscarPadre(R, v);
            if (P.izq == E){
                P.izq= hijo;
            } else {
                P.der= hijo;
            }
            E.izq= null;
            E.der= null;
            return E;
        }

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

    public Nodo BuscarNodo(Nodo N, String v) {
        if (N != null) {
            int c = v.compareToIgnoreCase(N.info);
            if (c == 0) {
                return N;
            }
            if (c < 0) {
                return BuscarNodo(N.izq, v);
            }
            return BuscarNodo(N.der, v);
        }
        return null;
    }

    public Nodo BuscarPadre(Nodo N, String v) {
        if (v.compareToIgnoreCase(N.info) < 0) {
            if (v.equalsIgnoreCase(N.izq.info)) {
                return N;
            }
            return BuscarPadre(N.izq, v);
        } else {
            if (v.equalsIgnoreCase(N.der.info)) {
                return N;
            }
            return BuscarPadre(N.der, v);
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