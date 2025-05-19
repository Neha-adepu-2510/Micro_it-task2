package com.generatorp;
import java.util.*;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password criteria
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean useUpper = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean useLower = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean useDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean useSpecial = scanner.nextLine().equalsIgnoreCase("yes");

        // Generate password
        String password = generatePassword(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("\nGenerated Password: " + password);
    }

    public static String generatePassword(int length, boolean upper, boolean lower, boolean digits, boolean special) {
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+{}[]|:;<>,.?/";

        StringBuilder allowedChars = new StringBuilder();

        if (upper) allowedChars.append(upperChars);
        if (lower) allowedChars.append(lowerChars);
        if (digits) allowedChars.append(digitChars);
        if (special) allowedChars.append(specialChars);

        if (allowedChars.length() == 0) {
            return "Error: No character types selected.";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }
}