package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private WeightedQuickUnionUF gridsUnion;
    private int gridLen;
    private int gridNum;
    private int numberOfOpenSites;
    private int[][] gridsOpen;

    public Percolation(int N) {
        if (N <= 0 ) {
            throw new IllegalArgumentException("N should more than zero!");
        }
        gridNum = N * N + 2;
        gridLen = N;
        gridsOpen = new int[N][N];

        gridsUnion = new WeightedQuickUnionUF(gridNum);
    }

    private int xyTo1d(int row, int col) {
        return row * gridLen + col + 1;
    }

    public void open(int row, int col) {
        int position = xyTo1d(row, col);
        if (row >= gridLen || col >= gridLen) {
            throw new IndexOutOfBoundsException("both row and col should less than or equal to N~~");
        }
        if (gridsOpen[row][col] != 1) {
            gridsOpen[row][col] = 1;
            numberOfOpenSites++;
        }
        if (row == 0) {
            gridsUnion.union(0, position);
            if (gridsOpen[row + 1][col] == 1) {
                gridsUnion.union(position, position + gridLen);
            }
        } else if (row == gridLen - 1) {
            gridsUnion.union(position, gridNum - 1);
            if (gridsOpen[row - 1][col] == 1) {
                gridsUnion.union(position, position - gridLen);
            }
        } else {
            if (gridsOpen[row + 1][col] == 1) {
                gridsUnion.union(position, position + gridLen);
            }
            if (gridsOpen[row - 1][col] == 1) {
                gridsUnion.union(position, position - gridLen);
            }
        }
        if (col == 0) {
            if (gridsOpen[row][col + 1] == 1) {
                gridsUnion.union(position, position + 1);
            }
        } else if (col == gridLen - 1) {
            if (gridsOpen[row][col - 1] == 1) {
                gridsUnion.union(position, position - 1);
            }
        } else {
            if (gridsOpen[row][col + 1] == 1) {
                gridsUnion.union(position, position + 1);
            }
            if (gridsOpen[row][col - 1] == 1) {
                gridsUnion.union(position, position - 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row >= gridLen || col >= gridLen) {
            throw new IndexOutOfBoundsException("both row and col should less than or equal to N~~");
        }
        return gridsOpen[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        if (row >= gridLen || col >= gridLen) {
            throw new IndexOutOfBoundsException("both row and col should less than or equal to N~~");
        }
        int position = xyTo1d(row, col);
        return gridsUnion.connected(0, position);
    }
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        return gridsUnion.connected(0, gridNum - 1);
    }
    public static void main(String[] args) {
        Percolation pl = new Percolation(3);
        pl.open(0, 0);
        if (pl.isOpen(0, 0)) {
            System.out.println(pl.numberOfOpenSites + "isOpen~~~");
        }
        pl.open(1, 0);
        pl.open(1, 1);
        if (pl.isFull(1, 1)) {
            System.out.println(pl.numberOfOpenSites + "isFull~~~");
        }
        if (!pl.percolates()) {
            System.out.println(pl.numberOfOpenSites + "not percolates~~~");
        }
        pl.open(2, 1);
        if (pl.percolates()) {
            System.out.println(pl.numberOfOpenSites + "percolates~~~");
        }

        PercolationStats ps = new PercolationStats(200, 200, new PercolationFactory());
        System.out.println(ps.mean() + "\n" + ps.stddev() + "\n" + ps.confidenceHigh() + "\n" + ps.confidenceLow());

    }


}
