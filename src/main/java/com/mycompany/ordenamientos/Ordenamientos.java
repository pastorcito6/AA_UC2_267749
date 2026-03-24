

import java.util.Arrays;

/**
 * CLASE: Ordenamientos
 * Contiene algoritmos de ordenamiento:
 * - Burbuja
 * - Selección
 * - Inserción
 * - Quicksort
 * 
 * Incluye:
 * ✔ Conteo de operaciones
 * ✔ Complejidad
 * ✔ Comentarios para depuración
 */
public class Ordenamientos {

    // BURBUJA
    public static void burbuja(int[] arr) {
        int n = arr.length; // 1 asignación
        int temp;           // 1 asignación

        for (int i = 0; i < n - 1; i++) { // n iteraciones

            // BREAKPOINT: inicio de cada pasada
            for (int j = 0; j < n - 1 - i; j++) { // n iteraciones

                if (arr[j] > arr[j + 1]) { // comparación

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // BREAKPOINT: ver intercambio
                }
            }
        }
    }
    /*
    T(n) ≈ n²
    COMPLEJIDAD: O(n²)
    */

    // 🟢 SELECCIÓN
    public static void seleccion(int[] arr) {
        int n = arr.length;
        int temp;
        int indiceMenor;

        for (int i = 0; i < n - 1; i++) {

            indiceMenor = i;

            // BREAKPOINT: nuevo mínimo
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            temp = arr[indiceMenor];
            arr[indiceMenor] = arr[i];
            arr[i] = temp;
        }
    }
    /*
    T(n) ≈ n²
    COMPLEJIDAD: O(n²)
    */

    // 🟡 INSERCIÓN
    public static void insercion(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            // BREAKPOINT: inserción de elemento
            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }
    /*
    Mejor caso: O(n)
    Peor caso: O(n²)
    */

    // QUICKSORT
    public static void quicksort(int[] arr, int inicio, int fin) {

        if (inicio < fin) {

            int pivoteIndice = particion(arr, inicio, fin);

            // DEBUG (te sirve para screenshots)
            System.out.println("Pivote en índice: " + pivoteIndice +
                               " -> " + Arrays.toString(arr));

            // Subarreglo izquierdo
            quicksort(arr, inicio, pivoteIndice - 1);

            // Subarreglo derecho
            quicksort(arr, pivoteIndice + 1, fin);
        }
    }

    // 🔴 PARTICIÓN
    public static int particion(int[] arr, int inicio, int fin) {

        int pivote = arr[fin]; // pivote
        int i = inicio - 1;

        // BREAKPOINT: inicio partición
        for (int j = inicio; j < fin; j++) {

            if (arr[j] < pivote) {

                i++;

                // intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // colocar pivote en posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }
    /*
    T(n) = 2T(n/2) + n

    Mejor caso: O(n log n)
    Promedio: O(n log n)
    Peor caso: O(n²)
    */

    // ⚫ IMPRIMIR
    public static void imprimirArreglo(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /*
    NOTA IMPORTANTE:
    Este main es SOLO de prueba.
    El proyecto principal debe usar la clase Main (menú).
    */
    public static void main(String[] args) {

        int[] numeros = {4, 2, 4, 3, 1, 4};

        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);

        quicksort(numeros, 0, numeros.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(numeros);
    }
}