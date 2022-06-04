public class ArrayDeque<T> implements Deque<T> {
    private T items[];
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int RFACTOR = 2;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    public int length(){ return items.length;}

    public void addSize(){
        int newLength = items.length * RFACTOR;
        T[] newItems = (T []) new Object[newLength];

        System.arraycopy(items,0,newItems,0,nextLast);

        int remainder = size - nextLast;
        int newNextFirst = newLength - remainder - 1;
        System.arraycopy(items,nextFirst + 1,newItems,newNextFirst + 1,remainder);

        nextFirst = newNextFirst;
        items = newItems;
    }

    public void deleteSize(){
        int newLength = items.length / RFACTOR;
        T[] newItems = (T []) new Object[newLength];

        if (nextFirst < nextLast){
            System.arraycopy(items,nextFirst + 1, newItems, 1, size);
        }else {
            System.arraycopy(items, nextFirst + 1, newItems, 1, items.length - nextFirst - 1);
            System.arraycopy(items, 0, newItems, items.length - nextFirst, nextLast);
        }

        nextFirst = 0;
        nextLast = size + 1;
        items = newItems;
    }

    @Override
    public void addFirst(T item){
        if (size == items.length - 1){
            addSize();
        }

        items[nextFirst] = item;
        size++;

        if (nextFirst == 0){
            nextFirst = items.length - 1;
        }else {
            nextFirst--;
        }
    }

    @Override
    public void addLast(T item){
        if (size == items.length - 1){
            addSize();
        }

        items[nextLast] = item;
        size++;

        if (nextLast == items.length - 1){
            nextLast = 0;
        }else {
            nextLast++;
        }
    }

    @Override
    public void printDeque(){
        if (nextFirst < nextLast){
            for (int i = nextFirst + 1;i < nextLast; i++){
                System.out.print(items[i] + " ");
            }
        }else {
            for (int i = nextFirst + 1;i < items.length; i++){
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++){
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        nextFirst++;
        if (nextFirst == items.length){
            nextFirst = 0;
        }
        size--;

        double R = (double)size/items.length;
        if (R < 0.25 & items.length >= 16){
            deleteSize();
        }
        return items[nextFirst];
    }

    @Override
    public T removeLast(){
        nextLast--;
        if (nextLast == 0){
            nextLast = items.length;
        }
        size--;

        double R = (double)size/items.length;
        if (R < 0.25 & items.length >= 16){
            deleteSize();
        }
        return items[nextLast];
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }

        int index0 = nextFirst + 1;
        int indexPosition = index0 + index;
        if (indexPosition <= items.length - 1) {
            return items[indexPosition];
        }else {
            indexPosition = indexPosition - items.length;
            return items[indexPosition];
        }
    }
}
