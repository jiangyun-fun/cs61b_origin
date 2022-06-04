public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> lld = new LinkedListDeque<>();

        int i = 0;
        while (i != word.length()) {
            lld.addLast(word.charAt(i));
            i++;
        }
        return lld;
    }
}
