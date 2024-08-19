package EJERCICIOS;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int numeroAnterior = Integer.MIN_VALUE; 

        System.out.println("Por favor, ingresa 10 números en orden creciente:");

        for (int i = 0; i < numeros.length; i++) {
            int numeroActual;
            while (true) {
                System.out.print("Número " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    numeroActual = scanner.nextInt();
                    if (numeroActual > numeroAnterior) {
                        
                        numeros[i] = numeroActual;
                        numeroAnterior = numeroActual;
                        break;
                    } else {
                       
                        System.out.println("Error: El número debe ser mayor que el anterior.");
                    }
                } else {
                    
                    System.out.println("Error: Por favor, ingresa un número entero.");
                    scanner.next(); 
                }
            }
        }

       
        System.out.println("Los números ingresados en orden creciente son:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

