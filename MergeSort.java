public class MergeSort {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        imprimirArray(array);

        mergeSort(array);

        System.out.println("Array ordenado:");
        imprimirArray(array);
    }

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

    private static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}