import BST.BST;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] numeros = {64, 25, 12, 22, 11};
            int opcion;

            System.out.println("=== Algoritmos de Estructuras y Ordenamiento ===");
            System.out.println("1. Ordenamiento Burbuja");
            System.out.println("2. Ordenamiento Seleccion");
            System.out.println("3. Ordenamiento Insercion");
            System.out.println("4. Quicksort");
            System.out.println("5. Merge Sort");
            System.out.println("6. EJECUTAR PRUEBA DE ÁRBOL BST");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.println("\nArreglo original:");
                imprimirArreglo(numeros);
            }

            switch (opcion) {
                case 1:
                    Ordenamientos.burbuja(numeros);
                    System.out.println("\nOrdenado con Burbuja:");
                    imprimirArreglo(numeros);
                    break;
                case 2:
                    Ordenamientos.seleccion(numeros);
                    System.out.println("\nOrdenado con Seleccion:");
                    imprimirArreglo(numeros);
                    break;
                case 3:
                    Ordenamientos.insercion(numeros);
                    System.out.println("\nOrdenado con Insercion:");
                    imprimirArreglo(numeros);
                    break;
                case 4:
                    Ordenamientos.quicksort(numeros, 0, numeros.length - 1);
                    System.out.println("\nOrdenado con Quicksort:");
                    imprimirArreglo(numeros);
                    break;
                case 5:
                    Ordenamientos.mergeSort(numeros, 0, numeros.length - 1);
                    System.out.println("\nOrdenado con Merge Sort:");
                    imprimirArreglo(numeros);
                    break;
                case 6:
                    ejecutarPruebaBST();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // Método para imprimir arreglos (evita errores de referencia)
    public static void imprimirArreglo(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    // Lógica del Árbol encapsulada para que el Main sea limpio
    public static void ejecutarPruebaBST() {
        BST arbol = new BST();
        System.out.println("\n=== INICIANDO PRUEBA DE ÁRBOL BINARIO ===");
        
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        System.out.println("Insertando: 50, 30, 70, 20, 40, 60, 80");
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.print("Recorrido Inorden (debe salir ordenado): ");
        arbol.inorden();

        System.out.println("\nEliminando la raiz (50)...");
        arbol.eliminar(50);

        System.out.print("Nuevo recorrido Inorden: ");
        arbol.inorden();

        System.out.println("\nBúsqueda de valores:");
        System.out.println("¿Existe el 30?: " + (arbol.buscar(30) ? "SÍ" : "NO"));
        System.out.println("¿Existe el 50?: " + (arbol.buscar(50) ? "SÍ" : "NO"));
    }
}