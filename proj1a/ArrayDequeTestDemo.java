public class ArrayDequeTestDemo {
/* addFirst is not OK; when nextLast = 0, nextFirst = length - 1, this method will yield a wrong output.
 * resize is OK
 * size is OK
 * isEmpty is OK
 * addLast is OK
 * get is OK
 * removeFirst is OK
 * removeLast is OK
 */
    public static void testIsEmpty(boolean bl, int size, int length){
        if (bl){
            System.out.println("Is empty, size is " + size + ", length is " + length);
        }else {
            System.out.println("Not empty, size is " + size + ", length is " + length);
        }
    }

    public static void main(String[] args){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        testIsEmpty(ad1.isEmpty(),ad1.size(),ad1.length());

        for (int i = 1; i < 10; i++)
            ad1.addLast(i);

        ad1.printDeque();
        testIsEmpty(ad1.isEmpty(),ad1.size(),ad1.length());

        System.out.println(ad1.get(1));

        for (int i = 1;i < 7;i++){
            ad1.removeLast();
        }

        ad1.printDeque();
        testIsEmpty(ad1.isEmpty(),ad1.size(),ad1.length());


        //int i=4,j=16;
        //System.out.println((double)i/j);


    }
}
