public class BinarySearch {
    public static void main(String[] args) {
        //Deklarazja tablicy wraz z inicjalizacją elementów.
        int[] numbers = {2, 4, 6, 8, 10};
        //Tutaj podajemy element którego indeks chcemy znaleźć
        int target = 8;
        //Tutaj zostanie przypisany numer indeksu elementu którego szukamy
        int index = binarySearch(numbers, 0, numbers.length - 1, target);

        //Sprawdzenie czy szukany element istnieje w tablicy.
        //Jeżeli z metody binarySearch została zwrócona liczba -1 to znaczy że szukany element nie istnieje w tablicy.
        if (index == -1)
            System.out.println("Element który chcesz znaleźć nie istnieje.");
        //W przeciwnym wypadku zostaje wypisany numer indeksu pod którym znajduje się element który nas interesuje.
        else
            System.out.println("Element został znaleziony w tablicy, jego indeks to " + index);
    }

    //Metoda Przeszukiwania binarnego
    private static int binarySearch(int[] numbers, int low, int high, int target) {
        //sprawdzenie czy podany element w target może jeszcze istnieć w tablicy.
        // Jeżeli warunek w tym if'ie będzie równy true to znaczy że szukany element nie istnieje w tablicy.
        if (low > high)
            return -1;

        //Deklaracja zmienne mid która będzie przechowywała środek przeszukiwanej tablicy.
        int mid = low + (high - low) / 2;

        //Sprawdzenie czy w środkowy element tablicy jest tym którego szukamy.
        if (numbers[mid] == target)
            return mid;
        //Sprawdzenie czy środkowy element tablicy jest większy niż target.
        //Jeżeli jest to zostaje ponownie wywołana metoda binarySearch i przekazana do niej lewa strona tablicy.
        else if (numbers[mid] > target)
            return binarySearch(numbers, low, mid - 1, target);
        //Jeżeli środkowy element tablicy nie jest większy niż target to wywoływana jest metoda binarySearch do której przekazana zostaje prawa strona tablicy.
        else
            return binarySearch(numbers, mid + 1, high, target);
    }
}
