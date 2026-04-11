import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int[] numeros = {64, 25, 12, 22, 11};
            int opcion;

            System.out.println("=== Algoritmos de Ordenamiento ===");
            System.out.println("1. Ordenamiento Burbuja");
            System.out.println("2. Ordenamiento Seleccion");
            System.out.println("3. Ordenamiento Insercion");
            System.out.println("4. Quicksort");
            System.out.println("5. Merge Sort"); // 🔵 NUEVO
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            System.out.println("\nArreglo original:");
            Ordenamientos.imprimirArreglo(numeros);

            switch (opcion) {

                case 1:
                    Ordenamientos.burbuja(numeros);
                    System.out.println("\nOrdenado con Burbuja:");
                    break;

                case 2:
                    Ordenamientos.seleccion(numeros);
                    System.out.println("\nOrdenado con Seleccion:");
                    break;

                case 3:
                    Ordenamientos.insercion(numeros);
                    System.out.println("\nOrdenado con Insercion:");
                    break;

                case 4:
                    Ordenamientos.quicksort(numeros, 0, numeros.length - 1);
                    System.out.println("\nOrdenado con Quicksort:");
                    break;

                case 5: // 🔵 NUEVO
                    Ordenamientos.mergeSort(numeros, 0, numeros.length - 1);
                    System.out.println("\nOrdenado con Merge Sort:");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    return;
            }

            Ordenamientos.imprimirArreglo(numeros);
        }
    }
}