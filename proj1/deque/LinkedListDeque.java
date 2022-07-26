package deque;

public class LinkedListDeque<T> {
    public class stuffnode{
        private stuffnode prev;
        public T item;
        private stuffnode next;

        public stuffnode(stuffnode p, T i, stuffnode n){
            prev = p;
            item = i;
            next = n;
        }

        public stuffnode(){
            item = null;
            prev = next = null;
        }
    }

    public stuffnode sentinel;
    private int size;

    /** create an empty linked list deque*/
    public LinkedListDeque(){
        size = 0;
        sentinel = new stuffnode();
        sentinel.prev = sentinel.next = sentinel;
    }

    /** creates a deep copy of other*/
    public LinkedListDeque(LinkedListDeque<T> other){
        size = 0;
        sentinel = new stuffnode();
        sentinel.prev = sentinel.next = sentinel;

        for(int i = 0; i < other.size; i += 1){
            addLast(other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        stuffnode t = new stuffnode(sentinel,item,sentinel);
        sentinel = new stuffnode(t,null,t);
        size += 1;
    }

    /** Adds an item of T to the back of the deque*/
    public void addLast(T item){
        stuffnode t = new stuffnode(sentinel.prev,item,sentinel);
        stuffnode p = sentinel.prev;
        p  = new stuffnode(p.prev,p.item,t);
        sentinel = new stuffnode(t, sentinel.item, sentinel.next);
    }

    /** return true if deque is empty ,false otherwise.*/
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    /** print the item in the deque from the front to the last.*/
    public void printDeque(){
        int num = size;
        stuffnode p = sentinel.next;
        while(num > 0){
            System.out.print(p.item + " ");
            p = p.next;
            num -= 1;
        }
        System.out.println("");
    }

    /** remove and return the item of the front of the deque*/
    public T removeFirst(){
        stuffnode t = sentinel.next;
        if(t == null){
            return null;
        }else{
            sentinel = new stuffnode(sentinel.prev,null,t.next);
            t.next = new stuffnode(sentinel,t.next.item,t.next.next);
            return t.item;
        }
    }

    public T removeLast(){
        stuffnode t = sentinel.prev;
        if(t == null) {
            return null;
        }else{
            sentinel = new stuffnode(t.prev,null,sentinel.next);
            t.prev = new stuffnode(t.prev.prev,t.prev.item, sentinel);
            return t.item;
        }
    }

    public T get(int index){
        int num = 0;
        stuffnode t = sentinel.next;
        if(index + 1 > size){
            return null;
        } else if (size == 0) {
            return null;
        }else{
            while(num < index){
                t = t.next;
                num += 1;
            }
            return t.item;
        }
    }


}
