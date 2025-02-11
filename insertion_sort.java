/**
 * Implementación del algoritmo de ordenación por inserción.
 */
public class insertion_sort {

    /**
     * Ordena un array utilizando el algoritmo de inserción.
     *
     * @param array El array a ordenar.
     */
    public void sort(int[] array) {
        // Tamaño del array
        int n = array.length;

        for (int i = 1; i < n; i++) {
            // Toma el elemento actual como la key
            int key = array[i];
            // Índice del elemento anterior a key
            int j = i - 1;

            // Mueve los elementos del array que son mayores que key un lugar a la derecha para hacer espacio para key
            while (j >= 0 && array[j] > key) {
                // Desplaza el elemento una posición a la derecha
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Pone la key en su posición correcta
            array[j + 1] = key;
        }
    }
}