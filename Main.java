import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int op;
        do {
            menu();
            op = sc.nextInt();
            sc.nextLine();

            switch(op) {
                case 1:
                    //inicializar/borrar    
                break;
                
                case 2:
                    //mostrar arbol
                break;

                case 3:
                    //buscar
                break;

                case 4:
                    //insertar
                break;

                case 5:
                    //eliminar
                break;

                case 6:
                    //modificar
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
                    System.out.println("Opcion invalida");
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
        System.out.println();
        System.out.println("Integrantes:");
        System.out.println("NOMBRE                              MATRICULA");    //Aqui agreguen su nombre y matricula
        System.out.println("Joshue Angel Regalado Martinez      25420019");
        System.out.println("Omar Emiliano Cuevas Peña           25420131");
        System.out.println("Zoe Valentina Morales García        25420058");
    }
}