import java.io.*;
import java.util.Random;

public class SortPerformanceTest {

    public static void main(String[] args) {
        generateRandomNumbers("numbers.txt", 3000);

        int[] numbers = readNumbersFromFile("numbers.txt");

        // Intervalos para medir el tiempo
        int[] intervals = {10, 100, 500, 1000, 2000, 3000};

        for (int n : intervals) {
            int[] arr = new int[n];
            System.arraycopy(numbers, 0, arr, 0, n);

            long startTime, endTime;

            // QuickSort
            startTime = System.nanoTime();
            QuickSort.quickSort(arr, 0, arr.length - 1);
            endTime = System.nanoTime();
            System.out.println("QuickSort with " + n + " numbers: " + (endTime - startTime) + " ns");

            // MergeSort
            System.arraycopy(numbers, 0, arr, 0, n);
            startTime = System.nanoTime();
            MergeSort.mergeSort(arr);
            endTime = System.nanoTime();
            System.out.println("MergeSort with " + n + " numbers: " + (endTime - startTime) + " ns");

            // RadixSort
            System.arraycopy(numbers, 0, arr, 0, n);
            startTime = System.nanoTime();
            RadixSort.radixSort(arr);
            endTime = System.nanoTime();
            System.out.println("RadixSort with " + n + " numbers: " + (endTime - startTime) + " ns");

            // SelectionSort
            System.arraycopy(numbers, 0, arr, 0, n);
            startTime = System.nanoTime();
            new selection_sort().sort(arr);
            endTime = System.nanoTime();
            System.out.println("SelectionSort with " + n + " numbers: " + (endTime - startTime) + " ns");

            // InsertionSort
            System.arraycopy(numbers, 0, arr, 0, n);
            startTime = System.nanoTime();
            new insertion_sort().sort(arr);
            endTime = System.nanoTime();
            System.out.println("InsertionSort with " + n + " numbers: " + (endTime - startTime) + " ns");
        }
    }

    private static void generateRandomNumbers(String filename, int count) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                writer.println(random.nextInt(10000)); // Números aleatorios entre 0 y 9999
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readNumbersFromFile(String filename) {
        int[] numbers = new int[3000];
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
}