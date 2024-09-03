import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.sql.SQLOutput;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        StringBuilder modify = new StringBuilder(encrypted);

        for (int i = 0; i < modify.length(); i++) {
            // Check if the character is an uppercase letter
            if (Character.isUpperCase(modify.charAt(i))) {
                // Shift character from 'A' (65) to 0-25 range
                modify.setCharAt(i, (char) (modify.charAt(i) - 65));

                // If the shifted value is less than 17, wrap it back around
                if (modify.charAt(i) < 17) {
                    // Wrap around by adding 74 to the shifted value
                    modify.setCharAt(i, (char)(modify.charAt(i) + 74));
                } else {
                    // Otherwise, adjust by adding 48 to the shifted value
                    modify.setCharAt(i, (char)(modify.charAt(i) + 48));
                }
            }

            // Check if the character is a lowercase letter
            if (Character.isLowerCase(modify.charAt(i))) {
                // Shift character from 'a' (97) to 0-25 range
                modify.setCharAt(i, (char)(modify.charAt(i) - 97));

                // If the shifted value is less than 17, wrap it back around
                if (modify.charAt(i) < 17) {
                    // Wrap around by adding 106 to the shifted value
                    modify.setCharAt(i, (char)(modify.charAt(i) + 106));
                } else {
                    // Otherwise, adjust by adding 80 to the shifted value
                    modify.setCharAt(i, (char)(modify.charAt(i) + 80));
                }
            }
        }

        // Convert StringBuilder to String and return the decrypted text
        decrypted = modify.toString();
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        int tens = 0;
        int ones = 0;
        String decrypted = "";
        StringBuilder modify = new StringBuilder(encrypted);

        // Remove all spaces from the string
        for (int i = modify.length() - 1; i >= 0; i--) {
            if (modify.charAt(i) == ' ') {
                modify.deleteCharAt(i);
            }
        }

        for (int i = 0; i + 1 < modify.length(); i++) {
            // Check if the character is '1'
            if (modify.charAt(i) == 49) { // ASCII for '1'
                // Calculate the tens and ones places for the triple-digit number
                tens = ((modify.charAt(i + 1) - 48) * 10);
                ones = (modify.charAt(i + 2) - 48);

                // Replace the triple-digit number with the character
                modify.delete(i, i + 2);
                modify.setCharAt(i, (char) (100 + tens + ones));
            } else {
                // Otherwise, handle as a double-digit number
                tens = ((modify.charAt(i) - 48) * 10);
                ones = (modify.charAt(i + 1) - 48);

                // Replace the double-digit number with the character
                modify.delete(i, i + 1);
                modify.setCharAt(i, (char) (tens + ones));
            }
        }

        // Convert StringBuilder to String and return the decrypted text
        decrypted = modify.toString();
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        int total = 0;
        StringBuilder modify = new StringBuilder(encrypted);
        StringBuilder cur = new StringBuilder();

        // Remove the first character, its a zero that is unecessisary
        modify.delete(0, 1);

        // Process each set of 8 characters as a binary string representing a byte
        for (int j = 0; j < 161; j++) {
            for (int i = 0; i < 8; i++) {
                // If the character is 1, add the corresponding bit value to the total
                if (modify.charAt(i) == 49) { // ASCII for 1
                    total += (1 << (7 - i));
                }
            }

            // Remove the  8 characters from the string
            modify.delete(0 , 8);

            cur.append((char) total);

            // Reset total for the next byte
            total = 0;
        }

        // Convert StringBuilder to String and return the decrypted text
        decrypted = cur.toString();
        return decrypted;
    }


    public String decryptFour(String encrypted){
        String decrypted = "";
        StringBuilder modify = new StringBuilder(encrypted);

        for(int i = 0; i < encrypted.length(); i++)
        {

        }
        int dingbat = 0x2700;
        //find shift distance
        int distance = dingbat - 'A';
        //do a really big caesar shift
        for(int i = 0; i < modify.length(); i++) {

            modify.setCharAt(i, (char) (modify.charAt(i) - distance));

        }

        decrypted = modify.toString();
        return decrypted;
    }
}
