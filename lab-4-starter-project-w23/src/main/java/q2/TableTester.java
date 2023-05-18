package main.java.q2;

import java.util.ArrayList;
import java.util.Arrays;

public class TableTester {

    public static void main(String[] args) {
        test_Table_initializesCorrectly();
        test_Table_canHandleFewerNumbersThanNumberOfSpaces();
        test_Table_canHandleMoreNumbersThanNumberOfSpaces();
        test_getRows();
        test_getCols();
        test_set();
        test_get();
        test_toString();
        test_equalityWithAnotherTable();
        test_inequalityWithAnotherTable();
        test_equalityWith2dArray();
        test_inequalityWith2dArray();
        test_as2dList();
    }

    private static void test_Table_initializesCorrectly() {
        Table t = new Table(2, 3, new int[]{1, 2, 3, 4, 5, 6});
        int[][] expectedData = {{1, 2, 3}, {4, 5, 6}};
        if (arrayEquals(t.getData(), expectedData)) {
            System.out.println("test_Table_initializesCorrectly passed");
        } else {
            System.out.println("test_Table_initializesCorrectly failed");
        }
    }

    private static void test_Table_canHandleFewerNumbersThanNumberOfSpaces() {
        Table t = new Table(2, 3, new int[]{1});
        int[][] expectedData = {{1, 0, 0}, {0, 0, 0}};
        if (arrayEquals(t.getData(), expectedData)) {
            System.out.println("test_Table_canHandleFewerNumbersThanNumberOfSpaces passed");
        } else {
            System.out.println("test_Table_canHandleFewerNumbersThanNumberOfSpaces failed");
        }
    }

    private static void test_Table_canHandleMoreNumbersThanNumberOfSpaces() {
        Table t = new Table(2, 3, new int[]{1, 2, 3, 4, 5, 6, 7});
        int[][] expectedData = {{1, 2, 3}, {4, 5, 6}};
        if (arrayEquals(t.getData(), expectedData)) {
            System.out.println("test_Table_canHandleMoreNumbersThanNumberOfSpaces passed");
        } else {
            System.out.println("test_Table_canHandleMoreNumbersThanNumberOfSpaces failed");
        }
    }

    private static void test_getRows() {
        Table t = new Table(3, 2, new int[]{1, 2, 3, 4, 5, 6});
        if (t.getRows() == 3) {
            System.out.println("test_getRows passed");
        } else {
            System.out.println("test_getRows failed");
        }
    }

    private static void test_getCols() {
        Table t = new Table(3, 2, new int[]{1, 2, 3, 4, 5, 6});
        if (t.getCols() == 2) {
            System.out.println("test_getCols passed");
        } else {
            System.out.println("test_getCols failed");
        }
    }

    private static void test_set() {
        Table t = new Table(2, 2, new int[]{1, 2, 3, 4});
        t.set(1, 1, 5);
        int[][] expectedData = {{1, 2}, {3, 5}};
        if (arrayEquals(t.getData(), expectedData)) {
            System.out.println("test_set passed");
        } else {
            System.out.println("test_set failed");
        }
    }

    private static void test_get() {
        Table t = new Table(2, 2, new int[]{1, 2, 3, 4});
        if (t.get(1, 1) == 4) {
            System.out.println("test_get passed");
        } else {
            System.out.println("test_get failed");
        }
    }

    private static void test_toString() {
        Table t = new Table(3, 2, new int[]{1, 2, 3, 4, 5, 6});
        String expectedString = "1 2\n3 4\n5 6";
        if (t.toString().equals(expectedString)) {
            System.out.println("test_toString passed");
        } else {
            System.out.println("test_toString failed");
        }
    }

    private static void test_equalityWithAnotherTable() {
        Table t1 = new Table(2, 2, new int[]{1, 2, 3, 4});
        Table t2 = new Table(2, 2, new int[]{1, 2, 3, 4});
        if (t1.equals(t2)) {
            System.out.println("test_equalityWithAnotherTable passed");
        } else {
            System.out.println("test_equalityWithAnotherTable failed");
        }
    }

    private static void test_inequalityWithAnotherTable() {
        Table t1 = new Table(2, 2, new int[]{1, 2, 3, 4});
        Table t2 = new Table(2, 2, new int[]{1, 2, 3, 5});
        if (!t1.equals(t2)) {
            System.out.println("test_inequalityWithAnotherTable passed");
        } else {
            System.out.println("test_inequalityWithAnotherTable failed");
        }
    }

    private static void test_equalityWith2dArray() {
        Table t = new Table(2, 2, new int[]{1, 2, 3, 4});
        int[][] array = {{1, 2}, {3, 4}};
        if (t.equals(array)) {
            System.out.println("test_equalityWith2dArray passed");
        } else {
            System.out.println("test_equalityWith2dArray failed");
        }
    }

    private static void test_inequalityWith2dArray() {
        Table t = new Table(2, 2, new int[]{1, 2, 3, 4});
        int[][] array = {{1, 2}, {3, 5}};
        if (!t.equals(array)) {
            System.out.println("test_inequalityWith2dArray passed");
        } else {
            System.out.println("test_inequalityWith2dArray failed");
        }
    }

    private static void test_as2dList() {
        Table t = new Table(2, 2, new int[]{1, 2, 3, 4});
        ArrayList<ArrayList<Integer>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList(1, 2)));
        expectedList.add(new ArrayList<>(Arrays.asList(3, 4)));
        if (listEquals(t.as2dList(), expectedList)) {
            System.out.println("test_as2dList passed");
        } else {
            System.out.println("test_as2dList failed");
        }
    }

    private static boolean arrayEquals(int[][] a1, int[][] a2) {
        if (a1.length != a2.length || a1[0].length != a2[0].length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[0].length; j++) {
                if (a1[i][j] != a2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean listEquals(ArrayList<ArrayList<Integer>> list1, ArrayList<ArrayList<Integer>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}