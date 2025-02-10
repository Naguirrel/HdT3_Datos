public class RadixSort {

    public static void radixSort(int[] array) {
        // Encuentra el número más grande para saber el número de dígitos
        int max = java.util.Arrays.stream(array).max().orElse(0);

        // Realiza el conteo de ordenación para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Array de salida
        int[] count = new int[10]; // Array de conteo (0-9)

        // Inicializa el array de conteo con 0s
        java.util.Arrays.fill(count, 0);

        // Almacena el conteo de cada dígito en el array de conteo
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Cambia el conteo[i] para que contenga la posición actual del dígito en el array de salida
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construye el array de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copia el array de salida al array original
        System.arraycopy(output, 0, array, 0, n);
    }
}
