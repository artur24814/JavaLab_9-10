package fileHandler;
import java.io.*;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class FileCopyReplaceSpaces {
    String inputFilePath;
    String outputFilePath;

    public boolean replaceSpaces(String replaceFromPattern, String replaceToPattern) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(replaceFromPattern, replaceToPattern);
                writer.write(modifiedLine);
                writer.newLine();
            }
            return true;
        } catch (FileNotFoundException fnfEx) {
            System.out.println("File not found");
            fnfEx.printStackTrace();
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
            ioe.printStackTrace();
        }
        return false;
    }
}
