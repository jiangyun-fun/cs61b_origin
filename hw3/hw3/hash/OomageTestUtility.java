package hw3.hash;

import java.io.Serializable;
import java.util.*;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        final double MIN_LF = (double) oomages.size() / 50;
        final double MAX_LF = (double) oomages.size() / 2.5;

        HashMap<Integer,LinkedList<Oomage>> buckets =new HashMap<Integer,LinkedList<Oomage>>(M);
        for (int i = 0; i < oomages.size(); i++) {
            Oomage o = (Oomage) oomages.get(i);

            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            if (!buckets.containsKey(bucketNum)) {
                LinkedList<Oomage> ll = new LinkedList<>();
                ll.add(o);
                buckets.put(bucketNum, ll);
            } else {
                if (!buckets.get(bucketNum).contains(o)) {
                    buckets.get(bucketNum).add(o);
                }
            }
        }

        for (Map.Entry<Integer,LinkedList<Oomage>>  ll: buckets.entrySet()) {
            if (ll.getValue().size() >= MIN_LF && ll.getValue().size() <= MAX_LF) {
                return true;
            }
        }
        return false;
    }
}
