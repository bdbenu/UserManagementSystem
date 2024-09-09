/**
 *benudharmunda
 * 31-Aug-2024
 *
 */
package com.bd.benu.util;

import java.security.SecureRandom;

/**
 * benudharmunda 31-Aug24
 */



public class UsersUtils {

    // Define the characters to include in the password
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    //private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Combine all characters into a single string
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS;

    // Create a SecureRandom instance for better randomness
    private static final SecureRandom random = new SecureRandom();

    // Method to generate a random password of a given length
    public static String generatePassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }

        return password.toString().toUpperCase();
    }

   


}
