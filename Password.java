/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordgenerator;

import java.util.Random;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 *
 * @author almarzooqih23
 */
public class Password {

    private int password_length;
    private String password;
    private boolean lowercase_alphabet;
    private boolean uppercase_alphabet;
    private boolean numerical;
    private boolean special_character;
    private final StringBuilder sb = new StringBuilder();

    //This array will be looped on to make a password.
    private final char[] lowercase_alphabet_characters = {'a', 'b', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
        'z'};
    private final char[] uppercase_alphabet_characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
        'Z'};
    private final char[] numerical_characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final char[] special_characters = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
        '-', '+', '=', '/', '.', ',', ':', ';'};

    public Password(int characters, boolean lowercase_alphabet, boolean uppercase_alphabet, boolean numerical, boolean special_character) {
        this.password_length = characters;
        this.lowercase_alphabet = lowercase_alphabet;
        this.uppercase_alphabet = uppercase_alphabet;
        this.numerical = numerical;
        this.special_character = special_character;
    }

    public void setCharacters(int characters) {
        this.password_length = characters;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCharacters() {
        return password_length;
    }

    public String getPassword() {
        return password;
    }

    //This methods loops in the array and returns the a random character to the password.
    public String generatePassword() {
        if (lowercase_alphabet == false && uppercase_alphabet == false
                && numerical == false && special_character == false) {
            password = sb.toString();
            copyPassword();
            return password;
        }
        Random rand = new Random();
        boolean orignal[] = {lowercase_alphabet, uppercase_alphabet, numerical, special_character};

        int i = 0;
        while (i < password_length) {
            if (orignal[0]) {
                sb.append(lowercase_alphabet_characters[rand.nextInt(25)]);
                orignal[0] = false;
                i++;
            } else if (orignal[1]) {
                sb.append(uppercase_alphabet_characters[rand.nextInt(25)]);
                orignal[1] = false;
                i++;
            } else if (orignal[2]) {
                sb.append(numerical_characters[rand.nextInt(9)]);
                orignal[2] = false;
                i++;
            } else if (orignal[3]) {
                sb.append(special_characters[rand.nextInt(17)]);
                orignal[3] = false;
                i++;
            } else {
                orignal[0] = !orignal[0] == lowercase_alphabet;
                orignal[1] = !orignal[1] == uppercase_alphabet;
                orignal[2] = !orignal[2] == numerical;
                orignal[3] = !orignal[3] == special_character;
            }
        }
        password = sb.toString();
        copyPassword();
        return password;
    }

    //This method copies the password to the clipboard
    private void copyPassword() {
        StringSelection sS = new StringSelection(password);
        Clipboard cB = Toolkit.getDefaultToolkit().getSystemClipboard();
        cB.setContents(sS, null);
    }
}
