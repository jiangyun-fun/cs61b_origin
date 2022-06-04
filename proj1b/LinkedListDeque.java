import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LinkedListDeque<T> implements Deque<T> {

    private  class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;


        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }

        private T getRecursive(int index) {
            if (index == 0) {
                return next.item;
            }

            return next.getRecursive(index-1);
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        T i = (T) "63";
        sentinel = new IntNode(null,i,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
/*
    public LinkedListDeque(int x){
        sentinel = new IntNode(sentinel,63,sentinel);
        sentinel.next = new IntNode(sentinel,x,sentinel.prev);
        //sentinel.prev = sentinel.prev.next;
        sentinel.prev = sentinel.next;
        size = 1;
    }
*/
    @Override
    public void addFirst(T item){
        sentinel.next = new IntNode(sentinel,item,sentinel.next);
        //sentinel.prev = sentinel.prev.next;
        sentinel.next.next.prev = sentinel.next;

        size++;
    }

    @Override
    public void addLast(T item){
        sentinel.prev = new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev.prev.next = sentinel.prev;

        size++;
    }

    @Override
    public boolean isEmpty(){
        if(size == 0){
            //System.out.println("LFASE");
            return TRUE;
        }
        //System.out.println("LFASE");
        return FALSE;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        IntNode ptr = sentinel.next;
        T i = (T) "63";

        while (ptr.item != i){
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }

        System.out.println();
    }

    @Override
    public T removeFirst(){
        T r = sentinel.next.item;

        sentinel.next = new IntNode(sentinel,sentinel.next.next.item,sentinel.next.next.next);
        sentinel.next.next.prev = sentinel.next;

        size--;

        return r;
    }

    @Override
    public T removeLast(){
        T r = sentinel.prev.item;

        sentinel.prev = new IntNode(sentinel.prev,sentinel.prev.prev.item,sentinel.prev.prev.prev);
        sentinel.prev.prev.next = sentinel.prev;

        size--;
        return r;
    }

    @Override
    public T get(int index){
        IntNode ptr = sentinel.next;
        while (index != 0){
            ptr = ptr.next;
            index--;
        }

        return ptr.item;
    }

    public T getRecursive(int index){
        return sentinel.getRecursive(index);
    }


    public static void main(String[] args){
        LinkedListDeque<Integer> llD1 = new LinkedListDeque<>();

        llD1.addFirst(15);
        llD1.addFirst(10);
        llD1.addLast(25);
        llD1.addLast(30);

/*
        llD1.addFirst("15");
        llD1.addFirst("10");
        llD1.addLast("25");
        llD1.addLast("30");
*/
        llD1.printDeque();
        llD1.isEmpty();
        System.out.println(llD1.size );

        System.out.println(llD1.get(0) + " " + llD1.get(2));

        System.out.println(llD1.getRecursive(0) + " " + llD1.getRecursive(2));

        System.out.println(llD1.removeFirst());

    }


}
