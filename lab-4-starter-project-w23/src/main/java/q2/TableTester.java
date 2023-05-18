package main.java.q2;

import java.util.ArrayList;
import java.util.Arrays;
import main.java.test.TestHelper;

public class TableTester {

    public static void main(String[] args) {
        test_Table_initializesCorrectly();
        test_Table_canHandleFewerNumbersThanNumberOfSpaces();
        test_Table_canHandleMoreNumbersThanNumberOfSpaces();

        test_getRows();
        test_getCols();

        test_set();
        test_get();

        test_equalityWithAnotherTable();
        test_inequalityWithAnotherTable();

        test_equalityWith2dArray();
        test_inequalityWith2dArray();

        test_as2dList();

        test_toString();
    }

    private static void test_Table_initializesCorrectly() {
        int[][] expectedData = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Table t = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        if (!equals(expectedData, t.getData())) {
            TestHelper.failMessage("Table constructor does not initialize the table correctly");
        } else {
            TestHelper.passMessage("Table constructor initializes the table correctly");
        }
    }

    private static void test_Table_canHandleFewerNumbersThanNumberOfSpaces() {
        int[][] expectedData = {
                {1, 2, 0},
                {4, 0, 0}
        };

        Table t = new Table(2, 3, new int[] {1, 2, 4});
        if (!equals(expectedData, t.getData())) {
            TestHelper.failMessage("Table constructor does not handle fewer numbers than the table has space for correctly");
        } else {
            TestHelper.passMessage("Table constructor handles fewer numbers than the table has space for correctly");
        }
    }

    private static void test_Table_canHandleMoreNumbersThanNumberOfSpaces() {
        int[][] expectedData = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Table t = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        if (!equals(expectedData, t.getData())) {
            TestHelper.failMessage("Table constructor does not handle more numbers than the table has space for correctly");
        } else {
            TestHelper.passMessage("Table constructor handles more numbers than the table has space for correctly");
        }
    }

    private static void test_getRows() {
        Table t = new Table(2, 3);
        if (t.getRows() != 2) {
            TestHelper.failMessage("getRows method does not return the expected value");
        } else {
            TestHelper.passMessage("getRows method returns the expected value");
        }
    }

    private static void test_getCols() {
        Table t = new Table(2, 3);
        if (t.getCols() != 3) {
            TestHelper.failMessage("getCols method does not return the expected value");
        } else {
            TestHelper.passMessage("getCols method returns the expected value");
        }
    }

    private static void test_set() {
        Table t = new Table(2, 3);
        t.set(1, 2, 5);
        int[][] expectedData = {
                {0, 0, 0},
                {0, 5, 0}
        };

        if (!equals(expectedData, t.getData())) {
            TestHelper.failMessage("set method does not set the correct value in the Table");
        } else {
            TestHelper.passMessage("set method sets the correct value in the Table");
        }
    }

    private static void test_get() {
        Table t = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        if (t.get(1, 2) != 6) {
            TestHelper.failMessage("get method does not return the expected value");
        } else {
            TestHelper.passMessage("get method returns the expected value");
        }
    }

    public static void test_toString() {
        Table t = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        String expectedString = "1 2 3\n4 5 6\n";

        if (!expectedString.equals(t.toString())) {
            TestHelper.failMessage("toString method does not return the expected string");
        } else {
            TestHelper.passMessage("toString method returns the expected string");
        }
    }

    public static void test_equalityWithAnotherTable() {
        Table t1 = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        Table t2 = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});

        if (!t1.equals(t2)) {
            TestHelper.failMessage("equals method does not evaluate two different tables with the same set of values as equal");
        } else {
            TestHelper.passMessage("equals method evaluates two different tables with the same set of values as equal");
        }
    }

    public static void test_inequalityWithAnotherTable() {
        Table t1 = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        Table t2 = new Table(2, 3, new int[] {2, 2, 3, 4, 5, 6});

        if (t1.equals(t2)) {
            TestHelper.failMessage("equals method incorrectly evaluates two different tables with a different set of values as equal");
        } else {
            TestHelper.passMessage("equals method correctly evaluates two different tables with a different set of values as not equal");
        }
    }

    public static void test_equalityWith2dArray() {
        Table t1 = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6}};

        if (!t1.equals(arr)) {
            TestHelper.failMessage("equals(int[][]) fails to equate a 2d array with an equivalent Table");
        } else {
            TestHelper.passMessage("equals(int[][]) detects equality");
        }
    }

    public static void test_inequalityWith2dArray() {
        Table t1 = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        int[][] arr = new int[][] {{2, 2, 3}, {4, 5, 6}};

        if (t1.equals(arr)) {
            TestHelper.failMessage("equals(int[][]) reports equality with a 2d array when it should NOT");
        } else {
            TestHelper.passMessage("equals(int[][]) detects inequality");
        }
    }

    public static void test_as2dList() {
        Table t = new Table(2, 3, new int[] {1, 2, 3, 4, 5, 6});
        ArrayList<ArrayList<Integer>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expectedList.add(new ArrayList<>(Arrays.asList(4, 5, 6)));

        if (!equals(expectedList, t.as2dList())) {
            TestHelper.failMessage("as2dList method does not return the expected ArrayList of ArrayLists");
        } else {
            TestHelper.passMessage("as2dList method returns the expected ArrayList of ArrayLists");
        }
    }