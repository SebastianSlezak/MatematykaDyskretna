/**
 * @author Sebastian Slezak
 */

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class TripleDES {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobranie tekstu od użytkownika
        System.out.println("Wprowadź tekst:");
        String text = scanner.nextLine();

        // Generowanie klucza i wektora inicjalizacji
        SecretKeySpec tripleDES = new SecretKeySpec(generateSecretKey(), "TripleDES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(generateInitializationVector());
        // Szyfrowanie tekstu
        byte[] encryptedMessageBytes = encrypt(text, tripleDES, ivParameterSpec);
        System.out.println("Zaszyfrowana tekst");
        System.out.println(Base64.getEncoder().encodeToString(encryptedMessageBytes));
        // Deszyfrowanie tekstu
        String decryptedMessage = decrypt(encryptedMessageBytes, tripleDES, ivParameterSpec);
        System.out.println("Odszyfrowana tekst");
        System.out.println(decryptedMessage);
    }

    /**
     * Metoda generująca klucz szyfrowania/deszyfrowania.
     * Klucz musi mieć 24 bajty (192 bitów).
     * W tym przypadku klucz jest stały i wynosi "9mng65v8jf4lxn93nabf981m".
     */
    static byte[] generateSecretKey() {
        return "9mng65v8jf4lxn93nabf981m".getBytes();
    }

    //Wektor inicjalizacji jest wejściem do prymitywu kryptograficznego używanego do zapewnienia stanu początkowego
    static byte[] generateInitializationVector() {
        return "a76nb5h9".getBytes();
    }

    /**
     * Szyfrowanie wiadomości przy użyciu klucza 'tripleDES'
     * Wiadomość jest przekształcona na bajty i w takiej postaci jest zwracana
     */
    static byte[] encrypt(String message, SecretKeySpec tripleDES, IvParameterSpec ivParameterSpec) {
        Cipher encryptCipher = null;
        byte[] encryptedMessageBytes = new byte[0];
        try {
            encryptCipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, tripleDES, ivParameterSpec);
            byte[] secretMessageBytes = secretMessageBytes(message);
            encryptedMessageBytes = encryptedMessageBytes(secretMessageBytes, encryptCipher);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return encryptedMessageBytes;
    }

    //Konwersja wiadomości na tablice bajtów z kodowaniem UTF-8
    static byte[] secretMessageBytes(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }

    //Szyfrowanie tablicy bajtów wiadomości za pomocą obiektu 'Cipher' i zwrócenie w postaci bajtów
    static byte[] encryptedMessageBytes(byte[] secretMessageBytes, Cipher encryptCipher) throws IllegalBlockSizeException, BadPaddingException {
        return encryptCipher.doFinal(secretMessageBytes);
    }

    /**
     * Deszyfrowanie zaszyfrowanej wiadomości za pomocą klucza i wektora inicjującego
     * Szyfrowany tekst jest konwertowany na bajty, a następnie deszyfrowany za pomocą obiektu 'Cipher' i zwrócony jako łańcuch znaków
     */
    static String decrypt(byte[] encryptedMessageBytes, SecretKeySpec tripleDES, IvParameterSpec ivParameterSpec) {
        byte[] decryptedMessageBytes = new byte[0];
        try {
            Cipher decryptCipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, tripleDES, ivParameterSpec);
            decryptedMessageBytes = decryptedMessageBytes(decryptCipher, encryptedMessageBytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
    }

    //Deszyfrowanie tablicy bajtów wiadomości za pomocą obiektu 'Cipher' i zwrócenie w postaci bajtów
    static byte[] decryptedMessageBytes(Cipher decryptCipher, byte[] encryptedMessageBytes) throws IllegalBlockSizeException, BadPaddingException {
        return decryptCipher.doFinal(encryptedMessageBytes);
    }
}
