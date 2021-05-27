package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        StringBuilder data = new StringBuilder("");

        boolean inIsProvided = false;
        boolean outIsProvided = false;

        String inputFilePath = "";
        String outputFilePath = "";

        for (int i = 0; i < args.length; i++) {

            if (args[i].charAt(0) == '-' && i == args.length - 1 ||
                    args[i].charAt(0) == '-' && args[i + 1].charAt(0) == '-') {

                System.out.println("Error in the arguments.");
                return;
            }

            switch (args[i]) {

                case "-mode" :
                    mode = args[i + 1];
                    i += 1;
                    break;

                case "-key" :
                    key = Integer.valueOf(args[i + 1]);
                    i += 1;
                    break;

                case "-data" :
                    data.append(args[i + 1]);
                    i += 1;
                    break;

                case "-in" :
                    inIsProvided = true;
                    inputFilePath = args[i + 1];
                    i += 1;
                    break;

                case "-out" :
                    outIsProvided = true;
                    outputFilePath = args[i + 1];
                    i += 1;
                    break;
            }
        }

        try {
            data = inIsProvided ? new StringBuilder(new String(Files.readAllBytes(Paths.get(inputFilePath)))) : data;
        } catch (IOException e) {
            System.out.println("IOException occurred while inputting.");
        }

        if ("enc".equals(mode)) {
            encrypt(data, key);
        } else {
            decrypt(data, key);
        }

        if (outIsProvided) {

            try (FileWriter fileWriter = new FileWriter(new File(outputFilePath))) {

                fileWriter.write(data.toString());
            } catch (IOException e) {
                System.out.println("IOException occurred while outputting.");
            }
        } else {
            System.out.println(data);
        }
    }

    static StringBuilder encrypt(StringBuilder sb, int key) {

        for (int i = 0; i < sb.length(); i++) {

            char c = (char) (sb.charAt(i) + key);
            sb.replace(i, i + 1, String.valueOf(c));
        }
        return sb;
    }

    static StringBuilder decrypt(StringBuilder sb, int key) {

        for (int i = 0; i < sb.length(); i++) {

            char c = (char) (sb.charAt(i) - key);
            sb.replace(i, i + 1, String.valueOf(c));
        }
        return sb;
    }
}
