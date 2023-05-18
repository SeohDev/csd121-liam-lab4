package main.java.q2;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {

    private int[][] data;

    public Table(int rows, int cols, int[] numbers) {
        data = new int[rows][cols];
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (index < numbers.length) {
                    data[row][col] = numbers[index];
                    index++;
                } else {
                    data[row][col] = 0;
                }
            }
        }
    }

    public int getRows() {
        return data.length;
    }

    public int getCols() {
        if (data.length == 0) {
            return 0;
        }
        return data[0].length;
    }

    public int[][] getData() {
        return data;
    }

    public void set(int row, int col, int number) {
        data[row][col] = number;
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                sb.append(data[row][col]);
                if (col < getCols() - 1) {
                    sb.append(" ");
                }
            }
            if (row < getRows() - 1) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public boolean equals(Table other) {
        if (getRows() != other.getRows() || getCols() != other.getCols()) {
            return false;
        }
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                if (data[row][col] != other.getData()[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(int[][] other) {
        if (other.length != getRows() || other.length == 0 || other[0].length != getCols()) {
            return false;
        }
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                if (other[row][col] != data[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> as2dList() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < getCols(); col++) {
                rowList.add(data[row][col]);
            }
            list.add(rowList);
        }
        return list;
    }
}