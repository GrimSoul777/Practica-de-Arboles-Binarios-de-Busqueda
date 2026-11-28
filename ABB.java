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

    public Nodo Eliminar(Nodo N, String v){
        Nodo E = BuscarNodo(N, v);
        if (E == null) {
            return E;
        }

        //ELIMINAR LA RAIZ
        if (E == R) {
            if (E.izq != null && E.der == null) {
                R = E.izq;
                E.izq = null;
                return E;
            }

            if (E.izq == null && E.der != null) {
                R = E.der;
                E.der = null;
                return E;
            }

            if (E.izq == null && E.der == null) {
                R = null;
                return E;
            }
        }

        //NODO SIN HIJOS
        if (E.izq == null && E.der == null) {
            Nodo P = BuscarPadre(R, v);

            if (P.izq == E) {
                P.izq = null;
            } else {
                P.der = null;
            }
            return E;
        }

        //NODO CON HIJO DERECHO
        if (E.izq == null && E.der != null) {
            Nodo P = BuscarPadre(R, v);

            if (P.izq == E) {
                P.izq = E.der;
            } else {
                P.der = E.der;
            }
            E.der = null;
            return E;
        }

        //NODO CON HIJO IZQUIERDO
        if (E.izq != null && E.der == null) {
            Nodo P = BuscarPadre(R, v);

            if (P.izq == E) {
                P.izq = E.izq;
            } else {
                P.der = E.izq;
            }
            E.izq = null;
            return E;
        }

        //NODO CON DOS HIJOS
        Nodo PT = E;
        Nodo T = E.izq;

        while (T.der != null) {
            PT = T;
            T = T.der;
        }

        String temp = E.info;
        E.info = T.info;
        T.info = temp;

        if (PT == E) {
            PT.izq = T.izq;
        } else {
            PT.der = T.izq;
        }
        T.izq = null;
        return T;
    }
    //Trabaja emi prepa
    public void Modificar(Nodo N, String v){
        Nodo E = Eliminar(N, v);
        if (E == null) {
            System.out.println("El nodo no existe");
        } else {
            System.out.println("Ingrese el nuevo valor: ");
            String nuevoValor = Main.sc.nextLine();
            
            R = Insertar(R, nuevoValor);
            System.out.println("Palabra modificada correctamente.");
        }
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
        if (N == null) {
            return null;
        }

        if (v.compareToIgnoreCase(N.info) < 0) {
            if (N.izq == null) {
                return null;
            }
            if (v.equalsIgnoreCase(N.izq.info)) {
                return N;
            }
            return BuscarPadre(N.izq, v);
        } else {
            if (N.der == null) {
                return null;
            }
            if (v.equalsIgnoreCase(N.der.info)) {
                return N;
            }
            return BuscarPadre(N.der, v);
        }
    }

    //RECORRIDOS
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