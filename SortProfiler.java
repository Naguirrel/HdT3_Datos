import java.io.*;
import java.util.Random;

public class SortProfiler {

    public static void main(String[] args) {
        int n = 1000; // Tamaño del array (puedes cambiarlo)
        String filename = "random_numbers.txt";

        // Generar un array de n elementos y guardarlo en un archivo
        generateRandomNumbers(filename, n);

        // Leer el array desde el archivo
        int[] numbers = readNumbersFromFile(filename);

        // Medir el tiempo de ejecución de cada algoritmo de ordenación
        profileSortingAlgorithms(numbers);
    }

    /**
     * Genera un array de n números aleatorios y los guarda en un archivo.
     *
     * @param filename Nombre del archivo donde se guardarán los números.
     * @param n        Cantidad de números aleatorios a generar.
     */
    private static void generateRandomNumbers(String filename, int n) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                writer.println(random.nextInt(10000)); // Números aleatorios entre 0 y 9999
            }
            System.out.println("Se generaron " + n + " números aleatorios en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee números desde un archivo y los devuelve en un array.
     *
     * @param filename Nombre del archivo desde donde se leerán los números.
     * @return Array de números leídos.
     */
    private static int[] readNumbersFromFile(String filename) {
        int[] numbers = new int[1000]; // Ajusta el tamaño según el valor de n
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                numbers[i++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    /**
     * Mide el tiempo de ejecución de cada algoritmo de ordenación.
     *
     * @param array Array de números a ordenar.
     */
    private static void profileSortingAlgorithms(int[] array) {
        int[] arr;

        // QuickSort
        arr = array.clone();
        long startTime = System.nanoTime();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("QuickSort: " + (endTime - startTime) + " ns");

        // MergeSort
        arr = array.clone();
        startTime = System.nanoTime();
        MergeSort.mergeSort(arr);
        endTime = System.nanoTime();
        System.out.println("MergeSort: " + (endTime - startTime) + " ns");

        // RadixSort
        arr = array.clone();
        startTime = System.nanoTime();
        RadixSort.radixSort(arr);
        endTime = System.nanoTime();
        System.out.println("RadixSort: " + (endTime - startTime) + " ns");

        // SelectionSort
        arr = array.clone();
        startTime = System.nanoTime();
        new selection_sort().sort(arr);
        endTime = System.nanoTime();
        System.out.println("SelectionSort: " + (endTime - startTime) + " ns");

        // InsertionSort
        arr = array.clone();
        startTime = System.nanoTime();
        new insertion_sort().sort(arr);
        endTime = System.nanoTime();
        System.out.println("InsertionSort: " + (endTime - startTime) + " ns");
    }
}