/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
    import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] numeros = {64, 25, 12, 22, 11};
            int opcion;
            
            System.out.println("=== Algoritmos de Ordenamiento ===");
            System.out.println("1. Ordenamiento Burbuja");
            System.out.println("2. Ordenamiento Seleccion");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            
            System.out.println("\nArreglo original:");
            ordenamientos.imprimirArreglo(numeros);
            
            switch (opcion) {
                case 1 -> {
                    ordenamientos.burbuja(numeros);
                    System.out.println("\nOrdenado con Burbuja:");
                }
                case 2 -> {
                    ordenamientos.seleccion(numeros);
                    System.out.println("\nOrdenado con Seleccion:");
                }
                default -> {
                    System.out.println("Opcion no valida.");
                    return;
                }
            }
            
            ordenamientos.imprimirArreglo(numeros);
        }
    }
}

