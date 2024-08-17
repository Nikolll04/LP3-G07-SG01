package EJERCICIOS;

import java.util.Scanner;

public class ejercicio5{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la tarifa para la primera hora (S/): ");
        double tarifaInicial = scanner.nextDouble();

        System.out.print("Ingrese la tarifa por cada hora adicional (S/): ");
        double tarifaAdicional = scanner.nextDouble();

        System.out.print("Ingrese el cargo máximo por día (S/): ");
        double tarifaMaxima = scanner.nextDouble();

        System.out.print("Ingrese el número de horas de estacionamiento: ");
        int numeroDeHoras = scanner.nextInt();

        double cargo = calcularCargo(numeroDeHoras, tarifaInicial, tarifaAdicional, tarifaMaxima);

        System.out.println("El cargo por " + numeroDeHoras + " horas es: S/ " + cargo);

        scanner.close();
    }

    public static double calcularCargo(int horas, double tarifaInicial, double tarifaAdicional, double tarifaMaxima) {
        if (horas <= 0) {
            return 0.0; 
        }

        double cargo;

        if (horas <= 1) {
            cargo = tarifaInicial;
        } else {
            cargo = tarifaInicial + (horas - 1) * tarifaAdicional;
        }

        if (cargo > tarifaMaxima) {
            cargo = tarifaMaxima;
        }

        return cargo;
    }
}
