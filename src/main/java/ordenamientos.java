/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class ordenamientos {

    // Metodo de ordenamiento burbuja
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

    // Metodo de ordenamiento por seleccion
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

    // Metodo de ordenamiento por insercion
    public static void insercion(int[] arr) {

        int n = arr.length;                 // 1 asignacion

        for (int i = 1; i < n; i++) {       // recorrido del arreglo

            int key = arr[i];               // elemento a insertar
            int j = i - 1;                  // posicion anterior

            while (j >= 0 && arr[j] > key) { // mover elementos mayores

                arr[j + 1] = arr[j];
                j = j - 1;

            }

            arr[j + 1] = key;               // colocar elemento en posicion correcta
        }

        // T(n) ≈ n² → O(n²)
    }

    // Metodo para imprimir el arreglo
    public static void imprimirArreglo(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}