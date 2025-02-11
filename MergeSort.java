/**
 * Implementación del algoritmo de ordenación por mezcla (Merge Sort).
 */
public class MergeSort {

    /**
     * Método principal para probar el algoritmo MergeSort.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        imprimirArray(array);

        mergeSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }

    /**
     * Ordena un array utilizando el algoritmo MergeSort.
     *
     * @param array El array a ordenar.
     */
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int medio = array.length / 2;
        int[] izquierda = new int[medio];
        int[] derecha = new int[array.length - medio];

        // Copiar elementos a los subarrays izquierdo y derecho
        for (int i = 0; i < medio; i++) {
            izquierda[i] = array[i];
        }
        for (int i = medio; i < array.length; i++) {
            derecha[i - medio] = array[i];
        }

        mergeSort(izquierda);
        mergeSort(derecha);

        mezclar(array, izquierda, derecha);
    }

    /**
     * Mezcla dos subarrays en un solo array ordenado.
     *
     * @param array El array original.
     * @param izquierda El subarray izquierdo.
     * @param derecha El subarray derecho.
     */
    private static void mezclar(int[] array, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Combinar los elementos de izquierda[] y derecha[] en array[]
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                array[k++] = izquierda[i++];
            } else {
                array[k++] = derecha[j++];
            }
        }

        // Copiar elementos restantes de izquierda[]
        while (i < izquierda.length) {
            array[k++] = izquierda[i++];
        }

        // Copiar elementos restantes de derecha[]
        while (j < derecha.length) {
            array[k++] = derecha[j++];
        }
    }

    /**
     * Imprime un array en la consola.
     *
     * @param array El array a imprimir.
     */
    private static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}