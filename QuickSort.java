/**
 * Implementación del algoritmo de ordenación rápida (Quick Sort).
 */
public class QuickSort {

    /**
     * Ordena un array utilizando el algoritmo QuickSort.
     *
     * @param arr El array a ordenar.
     * @param low El índice inicial del subarray.
     * @param high El índice final del subarray.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Particiona el array alrededor de un pivote.
     *
     * @param arr El array a particionar.
     * @param low El índice inicial del subarray.
     * @param high El índice final del subarray.
     * @return El índice del pivote.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}