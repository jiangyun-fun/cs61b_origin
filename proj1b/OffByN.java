public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int nn) {
        n = nn;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == n) {
            return true;
        }
        return false;
    }
}
