package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    private Node root;
    private int size;

    private class Node {
        K key;
        V val;
        Node left;
        Node right;
        int N;

        public Node(K k, V v,int N){
            key = k;
            val = v;
            this.N = N;
        }
    }

    /**
     * Removes all of the mappings from this map.
     */
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        Node x = getNode(root,key);
        return x == null ? null : x.val;
    }


    private Node getNode(Node x, K key) {
        if (x == null) return null;
        if (x.key == null) return null;
        else {
            int n = key.compareTo(x.key);
            if (n < 0) return getNode(x.left, key);
            else if (n > 0) return getNode(x.right, key);
            else return x;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.N;
    }

    @Override
    public void put(K key, V value) {
        root = put(root,key,value);
    }
    private Node put(Node x, K key, V value) {
        if (x == null) return new Node(key, value, 1);
        else {
            int n = key.compareTo(x.key);
            if (n < 0) x.left = put(x.left, key, value);
            else if (n > 0) x.right = put(x.right, key, value);
            else x.val = value;
            x.N = 1 + size(x.left) + size(x.right);
            return x;
        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key){
        if(!containsKey(key)){
            return null;
        }
        V toremove = get(key);
        root = remove(root, key);
        return toremove;

    }

    private Node remove(Node x, K key){
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x = remove(x.left, key);
        }
        else if (cmp > 0){
            x = remove(x.right, key);
        }
        else{
            if(x.right == null && x.left !=null){
                return x.left;
            }
            else if(x.left == null && x.right != null){
                return x.right;
            }
            else if(x.right != null){
                Node temp = x;
                x = min(temp.right);
                x.right = deletemin(temp.right);
                x.left = temp.left;
            }
        }
        return x;
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    private Node deletemin(Node x){
        if(x.left == null){
            // If x.left is null, meaning that x is the min, so replace it with
            // x.right, whether x.right is null or not does not matter.
            return x.right;
        }
        x.left = deletemin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }



    @Override
    public V remove(K key, V value) {
        if(!containsKey(key)){
            return null;
        }
        if(!value.equals(get(key))){
            return null;
        }
        V toremove = get(key);
        root = remove(root,key);
        return toremove;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        return new BSTIterator();
    }

    public class BSTIterator implements Iterator<K>{

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws java.util.NoSuchElementException if the iteration has no more elements
         */
        @Override
        public K next() {
            return null;
        }
    }



}