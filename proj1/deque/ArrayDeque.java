package deque;

public class ArrayDeque<T>  implements Deque<T> {
    protected int nextFirst;
    protected int nextLast;
    protected int size;
    public T[] items;

    /** create an empty linked list deque*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** creates a deep copy of other*/
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.items.length];
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        System.arraycopy(other.items,0,items,0,size);
    }




    /** resize the deque. */
    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for(int newIndex=0; newIndex < size; newIndex += 1 ){
            a[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = a;
        nextFirst = capacity -1;
        nextLast = size;
    }

    public void upsize(){
        if(size == items.length)
            resize(size*2);
    }

    public void downsize(){
        if(items.length >= 16 && items.length / size > 4){
            resize(size / 2);
        }
    }


    public int plusOne(int index){
        return (index+1) % this.items.length;
    }

    public  int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }

    /** Adds an item of type T to the front of the deque*/
    @Override
    public void addFirst(T item){
        upsize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of T to the back of the deque*/
    @Override
    public void addLast(T item){
        upsize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }


    @Override
    public int size(){
        return size;
    }

    /** print the item in the deque from the front to the last.*/
    @Override
    public void printDeque(){
        int num = 0;
        while(num < size){
            System.out.print(items[num]);
            num += 1;
        }
        System.out.println("");
    }

    /** remove and return the item of the front of the deque*/
    @Override
    public T removeFirst(){
        T t = items[plusOne(nextFirst)];
        nextFirst = plusOne(nextFirst);
        size -= 1;
        downsize();
        return t;
    }

    @Override
    public T removeLast(){
        T t = items[minusOne(nextLast)];
        nextLast = minusOne(nextLast);
        size -= 1;
        downsize();
        return t;
    }

    @Override
    public T get(int index){
        if(index > size - 1){
            return null;
        }else{
            return items[index];
        }
    }



}
