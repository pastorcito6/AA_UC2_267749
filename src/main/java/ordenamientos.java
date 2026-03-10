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
    // Compara elementos adyacentes y los intercambia si estan en orden incorrecto
    public static void burbuja(int[] arr) {
        int n = arr.length;          // 1 asignacion
        int temp;                    // 1 asignacion

        for (int i = 0; i < n - 1; i++) {           // 1 asig + n comparaciones + n incrementos
            for (int j = 0; j < n - 1 - i; j++) {   // se ejecuta n-1-i veces por cada i

                if (arr[j] > arr[j + 1]) {           // 1 comparacion
                    temp = arr[j];                   // 1 asignacion
                    arr[j] = arr[j + 1];             // 1 asignacion
                    arr[j + 1] = temp;               // 1 asignacion
                }
            }
        }
        // T(n) ≈ n^2 - n + constantes → O(n^2)
    }

    // Metodo de ordenamiento por seleccion
    // Busca el minimo en cada pasada y lo coloca en su posicion correcta
    public static void seleccion(int[] arr) {
        int n = arr.length;          // 1 asignacion
        int temp;                    // 1 asignacion
        int indiceMenor;             // 1 asignacion

        for (int i = 0; i < n - 1; i++) {           // 1 asig + n comparaciones + n incrementos
            indiceMenor = i;                         // 1 asignacion

            for (int j = i + 1; j < n; j++) {       // se ejecuta n-1-i veces por cada i
                if (arr[j] < arr[indiceMenor]) {     // 1 comparacion
                    indiceMenor = j;                 // 1 asignacion
                }
            }

            // Intercambiamos el minimo encontrado con la posicion i
            temp = arr[indiceMenor];                 // 1 asignacion
            arr[indiceMenor] = arr[i];               // 1 asignacion
            arr[i] = temp;                           // 1 asignacion
        }
        // T(n) ≈ n^2/2 + constantes → O(n^2)
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
