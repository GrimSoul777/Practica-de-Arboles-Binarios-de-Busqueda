import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    static ABB arbol = new ABB();

    public static void main(String[] args){
        int op;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine();

            switch(op) {
                case 1:
                    //inicializar/borrar
                    if (arbol.R == null) {
                        System.out.println("\nEl arbol ya esta vacio.");
                    } else {
                        arbol.Liberar(arbol.R);
                        arbol.R = null;
                        System.out.println("El arbol se ha liberado correctamente.");
                    }  
                break;
                
                case 2:
                    //mostrar arbol
                    if (arbol.R == null) {
                        //Para que no nos bajen puntos como la otra vez que no mostrabamos un mensaje si estaba vacio
                        System.out.println("\nEl arbol esta vacio.");
                    } else {
                        int recorrido;
                        System.out.println("\nTIPO DE RECORRIDO");
                        System.out.println("1. PreOrder");
                        System.out.println("2. InOrder");
                        System.out.println("3. PostOrder");
                        System.out.println("Seleccione una opcion:");
                        recorrido = sc.nextInt();
                        sc.nextLine();

                        System.out.println("\nCONTENIDO DEL ARBOL:");

                        switch (recorrido) {
                            case 1:
                                arbol.PreOrder(arbol.R);
                                break;

                            case 2:
                                arbol.InOrder(arbol.R);
                                break;

                            case 3:
                                arbol.PostOrder(arbol.R);
                                break;

                            default:
                                System.out.println("Opcion invalida.");
                        }
                    }
                break;

                case 3:
                    //buscar
                    if (arbol.R == null) {
                        System.out.println("\nEl arbol esta vacio.");
                    } else {
                        System.out.println("Ingresa la palabra que deseas buscar:");    //67676767676767676767 six seveeeeeeen
                        String buscar = sc.nextLine();

                        int nivel = arbol.Buscar(arbol.R, buscar, 0);
                        System.out.println();
                        if (nivel != -1) {
                            System.out.println("La palabra SI existe.");
                            System.out.println("Nivel del nodo: " + nivel);
                        } else {
                            System.out.println("La palabra NO existe en el arbol.");
                        }
                    }
                break;

                case 4:
                    //insertar
                    System.out.println("Ingresa la palabra que deseas insertar:");
                    String palabra = sc.nextLine();
                    arbol.R = arbol.Insertar(arbol.R, palabra);
                    System.out.println("\nPalabra insertada correctamente.");
                break;

                case 5:
                    //eliminar
                    if (arbol.R == null) {
                        System.out.println("\nEl arbol esta vacio.");
                    } else {
                        System.out.println("Ingresa la palabra que deseas eliminar:");
                        String elim = sc.nextLine();
                        if (arbol.Eliminar(arbol.R, elim) != null){
                            System.out.println("\nPalabra eliminada correctamente.");
                        }
                        else {
                            System.out.println("\nLa palabra NO existe en el arbol (no se elimino nada)");
                        }

                    }
                break;

                case 6:
                    //modificar
                    if (arbol.R == null) {
                        System.out.println("\nEl arbol esta vacio.");
                    } else {
                        System.out.println("Ingresa la palabra que deseas modificar:");
                        String modificar = sc.nextLine();
                        arbol.Modificar(arbol.R, modificar);
                    }
                break;

                case 7:
                    //Creditos
                    creditos();
                break;

                case 8:
                    //salir
                    System.out.println("Saliendo....");
                break;
            
                default:
                    System.out.println("\nOpcion invalida");
            }
        } while (op != 8);
    }

    public static void menu() {
        System.out.println();
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Inicializar/Borrar arbol");
        System.out.println("2. Mostrar arbol");
        System.out.println("3. Buscar");
        System.out.println("4. Insertar");
        System.out.println("5. Eliminar");
        System.out.println("6. Modificar");
        System.out.println("7. Creditos");
        System.out.println("8. Salir");
        System.out.println("Seleccione una opcion:");
    }

    public static void creditos() {
        System.out.println();
        System.out.println("Materia: Estructura de datos");
        System.out.println("Integrantes:");
        System.out.println("NOMBRE                              MATRICULA");    //Aqui agreguen su nombre y matricula
        System.out.println("Joshue Angel Regalado Martinez      25420019");
        System.out.println("Omar Emiliano Cuevas Peña           25420131");
        System.out.println("Zoe Valentina Morales García        25420058");
    }
}