/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.InterfazPrincipal;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class ControladorBusquedas extends InterfazPrincipal{
    
    //generar los 20000 datos tipo cadena aleatoriamente
    //libreria usada random
    
    public static void main(String[] args) {
        // Generate a list of 20000 random strings
        Random rand = new Random();
        int n = 20000;
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            int len = rand.nextInt(10) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                char c = (char) (rand.nextInt(26) + 'a');
                sb.append(c);
            }
            array[i] = sb.toString();
        }

        // Sort the list using shell sort
        shellSort(array);

        // Print the sorted list
        for (String s : array) {
//            System.out.println(s);
        }
    }
    //
    
    
    
    //metodo de ordanacion shell
    
    public static void shellSort(String[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                String temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(temp) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }
    
    public static void shellSortD(String[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                String temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(temp) < 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }
    
    //metodo de oredenacion quicksoirt
    
    public static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(String[] array, int low, int high) {
        String pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
    public static void quickSortD(String[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionD(array, low, high);
            quickSortD(array, low, pivotIndex - 1);
            quickSortD(array, pivotIndex + 1, high);
        }
    }

    public static int partitionD(String[] array, int low, int high) {
        String pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swapD(array, i, j);
            }
        }

        swapD(array, i + 1, high);
        return i + 1;
    }

    public static void swapD(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
