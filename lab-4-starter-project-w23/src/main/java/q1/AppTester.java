package main.java.q1;

import main.java.test.*;

public class AppTester {

    public static void main(String[] args) {
        test_App_typicalUsageWorks();
        test_App_repromptsOnInvalidFirstInt();
        test_App_repromptsOnInvalidSecondInt();
    }

    private static void test_App_typicalUsageWorks() {
        // Simulate the user pressing '2' then 'enter' then '3' then 'enter'
        TestHelper.setSystemIn("2%n3%n".formatted());  // Calling formatted() here converts %n to the system's line separator
        TestHelper.redirectSystemOut();  // So that the program output can be captured below...

        App.main(null);  // Run the program by calling the main method

        String expected = """
                Enter an integer: Enter another integer: Sum:               5
                Difference:       -1
                Product:           6
                Average:           2.50
                Distance:          1
                Min:               2
                Max:               3
                """;

        String actual = TestHelper.getOutput();  // Get the program output

        if (expected.equals(actual)) {
            TestHelper.passMessage("The app works on a typical set of inputs");
        } else {
            TestHelper.failMessage("The app fails on a typical set of inputs.%n%nExpected%n%n%s%nbut got%n%n%s".formatted(expected, actual));
        }
    }

    private static void test_App_repromptsOnInvalidFirstInt() {
        // Simulate the user pressing 'a' then 'enter' then '2' then 'enter'
        TestHelper.setSystemIn("a%n2%n".formatted());
        TestHelper.redirectSystemOut();

        App.main(null);

        String expected = """
                Enter an integer: That is not an integer
                Enter an integer: Enter another integer: Sum:               4
                Difference:        0
                Product:           0
                Average:           2.00
                Distance:          0
                Min:               2
                Max:               2
                """;

        String actual = TestHelper.getOutput();

        if (expected.equals(actual)) {
            TestHelper.passMessage("The app reprompts on an invalid first integer");
        } else {
            TestHelper.failMessage("The app does not reprompt on an invalid first integer.%n%nExpected%n%n%s%nbut got%n%n%s".formatted(expected, actual));
        }
    }

    private static void test_App_repromptsOnInvalidSecondInt() {
        // Simulate the user pressing '2' then 'enter' then 'b' then 'enter'
        TestHelper.setSystemIn("2%nb%n".formatted());
        TestHelper.redirectSystemOut();

        App.main(null);

        String expected = """
                Enter an integer: Enter another integer: That is not an integer
                Enter another integer: Sum:               4
                Difference:        0
                Product:           0
                Average:           2.00
                Distance:          0
                Min:               2
                Max:               2
                """;

        String actual = TestHelper.getOutput();

        if (expected.equals(actual)) {
            TestHelper.passMessage("The app reprompts on an invalid second integer");
        } else {
            TestHelper.failMessage("The app does not reprompt on an invalid second integer.%n%nExpected%n%n%s%nbut got%n%n%s".formatted(expected, actual));
        }
    }
}