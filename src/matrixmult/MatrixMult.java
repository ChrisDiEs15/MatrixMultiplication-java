/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrixmult;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class MatrixMult {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tamano = new Scanner(System.in);

        System.out.println("Programa que Multiplica dos matrices (n*m)*(m*o) con n y o diferentes");

        System.out.println("Ingrese la fila de la matriz 1");
        int fila1 = tamano.nextInt();
        System.out.println("Ingrese el tamano de las columnas ");
        int columna1 = tamano.nextInt();
        System.out.println("El numero de columnas de la matriz 2 sera igual que el numero de filas de la matriz 1 y es " + fila1);
        int fila2 = columna1;
        System.out.println("Ingrese el numero de filas de la matriz 2");
        int columna2 = tamano.nextInt();

        /*creates the matrix*/
        System.out.println("Ingrese los datos de la primera matriz");
        int matrix1[][] = matrixCreator(fila1, columna1);
        System.out.println("Inserte los datos de la segunda matriz");
        int matrix2[][] = matrixCreator(fila2, columna2);

        /*prin matrix to verify*/
        System.out.println("la primera matriz es ");
        showMatrix(matrix1, fila1, columna1);
        System.out.println("la segunda matriz es");
        showMatrix(matrix2, fila2, columna2);

        System.out.println("El tamano de la matriz resultado es de " + fila1 + " filas y de " + columna2 + " columnas.");

        /*pass to func to mult*/
        int matrixFinal[][] = matrixMult(matrix1, matrix2, fila1, fila2, columna1, columna2);

        /*pass to show func*/
        System.out.println("La matriz de resultados es: ");
        showMatrix(matrixFinal, fila1, columna2);

    }

    /*func to create a matriz n*m*/
    public static int[][] matrixCreator(int fila, int columna) {
        Scanner datosMatrix = new Scanner(System.in);

        int[][] matrixCreator = new int[fila][columna];
        for (int k = 0; k < fila; k++) {
            for (int l = 0; l < columna; l++) {
                System.out.println("Ingrese el dato de la fila " + k + " de la columna " + l);
                int nDato = datosMatrix.nextInt();
                matrixCreator[k][l] = nDato;
            }
        }

        return matrixCreator;
    }

    /*func to mult matrix*/
    public static int[][] matrixMult(int matrix1[][], int matrix2[][], int fila1, int fila2, int columna1, int columna2) {
        int[][] matrixResult = new int[fila1][columna2];

        for (int i = 0; i < fila1; i++) {
            for (int j = 0; j < columna2; j++) {
                for (int k = 0; k < fila2; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return matrixResult;
    }

    /*func to print the matrix*/
    public static void showMatrix(int matrix[][], int fila, int columna) {

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
