import java.util.Arrays;

/**
 * CLASE: Ordenamientos
 * Contiene algoritmos de ordenamiento:
 * - Burbuja
 * - Selección
 * - Inserción
 * - Quicksort
 * - MergeSort
 * 
 * Incluye:
 * ✔ Conteo de operaciones
 * ✔ Complejidad
 * ✔ Comentarios para depuración
 */
public class Ordenamientos {

    // BURBUJA
    public static void burbuja(int[] arr) {
        int n = arr.length;
        int temp;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /*
    COMPLEJIDAD: O(n²)
    */

    // 🟢 SELECCIÓN
    public static void seleccion(int[] arr) {
        int n = arr.length;
        int temp;
        int indiceMenor;

        for (int i = 0; i < n - 1; i++) {

            indiceMenor = i;

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
    COMPLEJIDAD: O(n²)
    */

    // 🟡 INSERCIÓN
    public static void insercion(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

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

    // 🔵 MERGE SORT
    public static void mergeSort(int[] arr, int izquierda, int derecha) {

        if (izquierda < derecha) {

            int medio = (izquierda + derecha) / 2;

            // Subarreglo izquierdo
            mergeSort(arr, izquierda, medio);

            // Subarreglo derecho
            mergeSort(arr, medio + 1, derecha);

            // Combinar
            merge(arr, izquierda, medio, derecha);
        }
    }

    // 🔵 MERGE
    public static void merge(int[] arr, int izquierda, int medio, int derecha) {

        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[izquierda + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[medio + 1 + j];

        int i = 0, j = 0;
        int k = izquierda;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    /*
    COMPLEJIDAD:
    O(n log n) en todos los casos
    Espacio: O(n)
    */

    // 🔴 QUICKSORT
    public static void quicksort(int[] arr, int inicio, int fin) {

        if (inicio < fin) {

            int pivoteIndice = particion(arr, inicio, fin);

            System.out.println("Pivote en índice: " + pivoteIndice +
                               " -> " + Arrays.toString(arr));

            quicksort(arr, inicio, pivoteIndice - 1);
            quicksort(arr, pivoteIndice + 1, fin);
        }
    }

    // 🔴 PARTICIÓN
    public static int particion(int[] arr, int inicio, int fin) {

        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {

            if (arr[j] < pivote) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }
    /*
    Mejor: O(n log n)
    Promedio: O(n log n)
    Peor: O(n²)
    */

    // ⚫ IMPRIMIR
    public static void imprimirArreglo(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // MAIN DE PRUEBA
    public static void main(String[] args) {

        int[] numeros = {4, 2, 4, 3, 1, 4};

        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);

        // 🔁 CAMBIA AQUÍ EL MÉTODO QUE QUIERAS PROBAR

        // burbuja(numeros);
        // seleccion(numeros);
        // insercion(numeros);
        // quicksort(numeros, 0, numeros.length - 1);
        mergeSort(numeros, 0, numeros.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(numeros);
    }
}