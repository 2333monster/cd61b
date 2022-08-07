package bstmap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {
    private class Node {
        K key;
        V value;
        Node left, right;
        int N;

        Node(K key, V value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    public BSTMap() {

    }


    @Override
    public void clear() {
        root.left = null;
        root.right = null;
        root = new Node(null, null, 0);
    }


    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node x, K key) {
        if (x == null) return null;
        if (x.key == null) return null;
        else {
            int cmp = x.key.compareTo(key);
            if (cmp < 0) return getNode(x.right, key);
            else if (cmp > 0) return getNode(x.left, key);
            else return x;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);

    }

    private Node put(Node x, K key, V value) {
        if (x == null) return new Node(key, value, 1);
        else {
            int cmp = x.key.compareTo(key);
            if (cmp < 0) x.right = put(x.right, key, value);
            else if (cmp > 0) x.left = put(x.left, key, value);
            else x.value = value;
            x.N = 1 + size(x.left) + size(x.right);
            return x;
        }
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }


    private class BSTMapIterator implements Iterator<K> {

        LinkedList<Node> list;
        public BSTMapIterator(){
            list = new LinkedList<>();
            list.addLast(root);
        }
        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public K next() {
            Node node = list.removeFirst();
            list.addLast(node.left);
            list.addLast(node.right);
            return node.key;
        }
    }
}