import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class NumberGuessingTest {

    @Test
    public void testNonIntegerInputHandledGracefully() {
        String input = "abc\n1\n2\n3\n4\n5\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            NumberGuessing.guessingNumberGame();

            String output = outContent.toString();
            assertTrue(output.contains("Invalid input. Please enter an integer."));
        } catch (Exception e) {
            fail("The program crashed when given non-integer input.");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testValidInputProcessedCorrectly() {
        String input = "5\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            NumberGuessing.guessingNumberGame();

            String output = outContent.toString();
            // You might want to update this depending on your game's response for a valid guess
            assertTrue(output.contains("Guess a number"));
        } catch (Exception e) {
            fail("The program crashed on valid input.");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testGuessTooLow() {
        String input = "1\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            NumberGuessing.guessingNumberGame();

            String output = outContent.toString();
            assertTrue(output.toLowerCase().contains("too low") || output.toLowerCase().contains("try again"));
        } catch (Exception e) {
            fail("The program crashed on low guess input.");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testGuessTooHigh() {
        String input = "100\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            NumberGuessing.guessingNumberGame();

            String output = outContent.toString();
            assertTrue(output.toLowerCase().contains("too high") || output.toLowerCase().contains("try again"));
        } catch (Exception e) {
            fail("The program crashed on high guess input.");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCorrectGuess() {
        // Assuming the correct number is 5, simulate guessing it directly
        String input = "5\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(outContent));

            NumberGuessing.guessingNumberGame();

            String output = outContent.toString();
            assertTrue(output.toLowerCase().contains("correct") || output.toLowerCase().contains("you win"));
        } catch (Exception e) {
            fail("The program crashed on correct guess input.");
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
