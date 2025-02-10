

public class selection_sort {

    public void sort(int[] array) {
        int n = array.length;

        // Recorre todo el array
        for (int i = 0; i < n - 1; i++) {

            // al final este será el index del elemento menor de todo el array
            int minIndex = i;

            // Segundo for que recorre el array un espacio más arriba
            for (int j = i + 1; j < n; j++) {
                // Si el elemento siguiente es menor al elemento actual
                if (array[j] < array[minIndex]) {
                    // el indice del elemento menor 
                    minIndex = j;
                }
            }

            // Intercambia el elemento mínimo encontrado con el primer elemento de la iteración principal
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
