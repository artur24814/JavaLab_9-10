import fileHandler.FileCopyReplaceSpaces;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileCopyReplaceSpacesTest {
    private static final String INPUT_FILE = "testInput.txt";
    private static final String OUTPUT_FILE = "testOutput.txt";

    @BeforeEach
    void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE))) {
            writer.write("This is a test.");
            writer.newLine();
            writer.write("Replace spaces with hyphens.");
        }
    }

    @AfterEach
    void tearDown() {
        new File(INPUT_FILE).delete();
        new File(OUTPUT_FILE).delete();
    }

    @Test
    void testReplaceSpacesSuccessfully() throws IOException {
        FileCopyReplaceSpaces fileHandler = new FileCopyReplaceSpaces(INPUT_FILE, OUTPUT_FILE);

        boolean result = fileHandler.replaceSpaces(" ", "-");

        assertTrue(result, "The replaceSpaces method should return true when executed correctly.");

        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
            assertEquals("This-is-a-test.", reader.readLine());
            assertEquals("Replace-spaces-with-hyphens.", reader.readLine());
        } catch (IOException e) {
            fail("Failed to read the output file: " + e.getMessage());
        }
    }

//    @Test
//    void testReplaceSpacesWithInvalidInputFile() throws IOException {
//        FileCopyReplaceSpaces fileHandler = new FileCopyReplaceSpaces("nonexistent.txt", OUTPUT_FILE);
//
//        boolean result = fileHandler.replaceSpaces(" ", "-");
//
//        assertFalse(result);
//    }
//
//    @Test
//    void testReplaceSpacesWithInvalidOutputFile() throws IOException {
//        FileCopyReplaceSpaces fileHandler = new FileCopyReplaceSpaces(INPUT_FILE, "nonexistent.txt");
//
//        boolean result = fileHandler.replaceSpaces(" ", "-");
//
//        assertFalse(result);
//    }
}
