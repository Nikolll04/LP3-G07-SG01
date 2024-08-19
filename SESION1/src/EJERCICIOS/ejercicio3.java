package EJERCICIOS;

import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        int numLanzamientos = 20000;

        int[] frecuencias = new int[6];


        Random random = new Random();

     
        for (int i = 0; i < numLanzamientos; i++) {
            int resultado = random.nextInt(6) + 1; 

      
            if (resultado >= 1 && resultado <= 6) {
                frecuencias[resultado - 1]++;
            } else {
                System.out.println("Error: Resultado del dado fuera del rango esperado: " + resultado);
            }
        }

   
        System.out.println("Frecuencias de cada cara del dado (1-6):");
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencias[i]);
        }
    }
}
