package fileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
    public static boolean createFileIfNotExists(String filePath) {
        return createFileIfNotExists(filePath, "");
    }

    public static boolean createFileIfNotExists (String filePath, String text) {
        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            try {
                if (inputFile.createNewFile()) {
                    System.out.println("File has been created: " + filePath);
                    if (!text.isEmpty()) {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                            writer.write(text);
                        }
                    }
                } else {
                    throw new IOException("Failed to create input file.");
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
