package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import jdk.jshell.Snippet;

public class PercolationStats {
    private int n;
    private int t;
    private double[] xi;
    private PercolationFactory pf;


    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Anyone should more than zero");
        }
        t = T;
        n = N;
        pf = pf;
        xi = new double[t];

        int i = 0;
        while (i < t) {
            Percolation pl = pf.make(n);
            while (!pl.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                pl.open(row, col);
            }
            xi[i] = (double)pl.numberOfOpenSites() / (n * n);
            i++;
        }
    }


    public double mean() {
        return StdStats.mean(xi);
    }
    public double stddev() {
        return StdStats.stddev(xi);
    }
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(t);
    }
}
