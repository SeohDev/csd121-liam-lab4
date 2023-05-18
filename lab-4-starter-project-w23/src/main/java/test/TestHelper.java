package main.java.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * A few utility methods to help make writing tests a bit simpler
 */
public class TestHelper {

    /**
     * These constants encode text color in terminals.
     * See https://stackoverflow.com/a/33206814/1030345
     */
    private static final String TEXT_GREEN = "\u001B[32m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_RESET = "\u001B[0m";

    /**
     * Stores the current output stream, so that console output can be read
     */
    private static ByteArrayOutputStream outStream;

    /**
     * For capturing program output (into outStream)
     */
    private static PrintStream testOut;

    /**
     * For printing test messages (via passMessage and failMessage)
     */
    private static final PrintStream stdOut = System.out;


    /**
     * Sets System.in to an InputStream based on the given input string
     * @param inputs The sequence of inputs that will be provided to the scanner (instead of the usual input from the keyboard)
     */
    public static void setSystemIn(String inputs) {
        System.setIn(new ByteArrayInputStream(inputs.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Change the PrintStream to which System.out prints, so that program output can be captured.
     * Once redirectSystemOut has been called, getOutput will yield as a String the output produced by the program
     * being tested.
     *
     * For example:
     *
     *  TestHelper.redirectSystemOut();                // Redirect System.out to the test helper's testOut
     *
     *  // Run some testing code
     *
     *  String output = TestHelper.getOutput();   // Read the text that has been printed to System.out
     *
     *  // Check that the output is as expected
     */
    public static void redirectSystemOut() {
        outStream = new ByteArrayOutputStream();
        testOut = new PrintStream(outStream,true, StandardCharsets.UTF_8);
        System.setOut(testOut);
    }

    /**
     * Resets System.out to the default PrintStream
     */
    public static void resetSystemOut() {
        System.setOut(stdOut);
    }

    /**
     * @return The output produced by the program being tested (provided that setSystemOut has been called first)
     */
    public static String getOutput() {
        return outStream.toString(StandardCharsets.UTF_8);
    }

    /**
     * Print a 'pass' message
     * @param message  The message to print
     */
    public static void passMessage(String message) {
        var oldOut = testOut;
        System.setOut(stdOut);
        System.out.printf("%sPASS: %s%s%n", TEXT_GREEN, message, TEXT_RESET);
        System.setOut(oldOut);
    }

    /**
     * Print a 'fail' message
     * @param message The message to print
     */
    public static void failMessage(String message) {
        var oldOut = testOut;
        System.setOut(stdOut);
        System.out.printf("%sFAIL: %s%s%n", TEXT_RED, message, TEXT_RESET);
        System.setOut(oldOut);
    }

}
