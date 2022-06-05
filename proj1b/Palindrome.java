
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> lld = new LinkedListDeque<>();

        int i = 0;
        while (i != word.length()) {
            lld.addLast(word.charAt(i));
            i++;
        }
        return lld;
    }



    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

        /* don't use get()
        int size = lld.size();
        for (int i = 0; i <= size / 2; i++) {
            if (lld.get(i).equals(lld.get(size - 1 - i))) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }*/
    public boolean isPalindrome(String word, CharacterComparator cc) {
        CharacterComparator cc1 = cc;

        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            //if (word.charAt(i) != word.charAt(len - i - 1)) {
            if (!cc1.equalChars(word.charAt(i), word.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }

}
