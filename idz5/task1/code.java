package com.tasks6.rle;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            System.out.println("");
            return;
        }

        StringBuilder encodedString = new StringBuilder();

        char currentChar = args[0].charAt(0);
        int count = 1;

        for (int i = 1; i < args[0].length(); i++) {
            if (args[0].charAt(i) == currentChar) {
                count++;
            } else {
                encodedString.append(currentChar);
                if (count > 1) {
                    if (count < 10) {
                        encodedString.append(count);
                    } else {
                        int firstGroupCount = count / 9;
                        int remainingCount = count % 9;
                        for (int j = 0; j < firstGroupCount; j++) {
                            encodedString.append(9);
                            encodedString.append(currentChar);
                        }
                        if (remainingCount > 1) {
                            encodedString.append(remainingCount);
                        }
                    }
                }
                currentChar = args[0].charAt(i);
                count = 1;
            }
        }

        encodedString.append(currentChar);
        if (count > 1) {
            if (count < 10) {
                encodedString.append(count);
            } else {
                int firstGroupCount = count / 9;
                int remainingCount = count % 9;
                for (int j = 0; j < firstGroupCount; j++) {
                    encodedString.append(9);
                    encodedString.append(currentChar);
                }
                if (remainingCount > 1) {
                    encodedString.append(remainingCount);
                }
            }
        }

        System.out.println(encodedString.toString());
    }
}

