import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class NumberGuessingTest {

    @Test
    public void testNonIntegerInputHandledGracefully() {
        // Simulated user input: one invalid ("abc") and five valid numbers
        String input = "abc\n1\n2\n3\n4\n5\n";

        // Save original System input/output
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            // Redirect System.in and System.out
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            // Run the game
            NumberGuessing.guessingNumberGame();

            // Check the output contains our error message
            String output = outContent.toString();
            assertTrue(output.contains("Invalid input. Please enter an integer."));
        } catch (Exception e) {
            fail("The program crashed when given non-integer input.");
        } finally {
            System.setIn(originalIn);   // Restore original System.in
            System.setOut(originalOut); // Restore original System.out
        }
    }
}
