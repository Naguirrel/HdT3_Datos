import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para verificar la funcionalidad de diferentes algoritmos de ordenación.
 */
public class SortTest {

    /**
     * Prueba el algoritmo QuickSort.
     */
    @Test
    public void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    /**
     * Prueba el algoritmo MergeSort.
     */
    @Test
    public void testMergeSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    /**
     * Prueba el algoritmo RadixSort.
     */
    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    /**
     * Prueba el algoritmo SelectionSort.
     */
    @Test
    public void testSelectionSort() {
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        new selection_sort().sort(arr);
        assertArrayEquals(expected, arr);
    }

    /**
     * Prueba el algoritmo InsertionSort.
     */
    @Test
    public void testInsertionSort() {
        int[] arr = {12, 11, 13, 5, 6};
        int[] expected = {5, 6, 11, 12, 13};
        new insertion_sort().sort(arr);
        assertArrayEquals(expected, arr);
    }
}