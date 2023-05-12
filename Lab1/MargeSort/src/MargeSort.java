import java.util.Arrays;

public class MargeSort {
    public static void main(String[] args) {
        //Deklaracja i inicjalizacja tablicy którą chcemy posortować
        int[] arr = {5, 3, 8, 6, 2, 7, 1, 4};
        //Wywołanie metody sort i przekazanie do niej tablicy
        sort(arr);
        //Wypisanie posortowanej tablicy
        System.out.println(Arrays.toString(arr));
    }

    //Metoda Sortujaca
    public static void sort(int[] arr) {
        //Sprawdzenie, czy tablica jest pusta lub zawiera tylko jeden element
        if (arr == null || arr.length <= 1) {
            return;
        }
        //Wywołanie meody margeSort wraz z przekazaniem tablicy oraz odpowiedniej strony tablicy.
        mergeSort(arr, 0, arr.length - 1);
    }

    //Metoda z algorytmem Sortowania przez scalalnie
    private static void mergeSort(int[] arr, int left, int right) {
        //Warunek stopu - jeśli pozostał tylko jeden element w tablicy
        if (left < right) {
            //Jeżeli lewa strona jest mniejsza
            int middle = (left + right) / 2;
            //Rekurencyjne sortowanie lewej połowy tablicy
            mergeSort(arr, left, middle);
            //Rekurencyjne sortowanie prawej połowy tablicy
            mergeSort(arr, middle + 1, right);
            //Scalenie dwóch posortowanych połówek tablicy
            merge(arr, left, middle, right);
        }
    }

    //Metoda scalająca dwie posortowane połówki tablicy w jedną posortowaną całość
    private static void merge(int[] arr, int left, int middle, int right) {
        //Utworzenie tymczasowej tablicy o rozmiarze takim, jak oryginalna tablica
        int[] temp = new int[arr.length];
        //Skopiowanie elementów z oryginalnej tablicy do tymczasowej
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        //Ustawienie wskaźników na początki obu połówek tablicy oraz wskaźnika na początek tablicy tymczasowej
        int i = left, j = middle + 1, k = left;
        //Porównywanie elementów z obu połówek tablicy i umieszczanie ich w odpowiedniej kolejności w tablicy wynikowej
        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        //Umieszczenie pozostałych elementów z lewej połowy tablicy w tablicy wynikowej
        while (i <= middle) {
            arr[k] = temp[i];
            k++;
            i++;
        }
        //Umieszczenie pozostałych elementów z prawej połowy tablicy w tablicy wynikowej
        while (j <= right) {
            arr[k] = temp[j];
            k++;
            j++;
        }
    }
}
