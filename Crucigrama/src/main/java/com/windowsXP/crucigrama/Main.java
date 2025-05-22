package com.windowsXP.crucigrama;

import java.util.Scanner;// victorrrrrrrrrrrrrrrrrrrrr
//todo este cambio lo hizo victor
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] palabras;
        boolean error = false;
        int palabraMasLarga = 0;

        System.out.println("Ingrese cant de palabras");
        int n = sc.nextInt();
        palabras = new String[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Ingrese la Palabra "+ (i+1) + ": ");
            String palabra = sc.next();

            if (palabra.length() <= 2) {
                System.out.println("Menos de 2 caracteres");
                error = true;
                break;
            }

            palabras[i] = palabra;

            // Actualizar la palabra más larga
            if (palabra.length() > palabraMasLarga) {
                palabraMasLarga = palabra.length();
            }
        }

        if (!error) {
            Crucigrama crucigrama = new Crucigrama(palabras, palabraMasLarga);
            crucigrama.imprimirCrucigrama();
        } else {
            System.out.println("Error");
        }
    }
}
