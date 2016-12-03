package task1;

import java.util.Iterator;

interface LinkedList<E> extends Iterable<E> {

    void add(E element);

    E get(int index);

    boolean contains(E element);

    boolean delete(E element);

    E delete(int index);

    boolean isEmpty();

    int size();

    int clean();
}


class Node<T> {

    T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}

public class LinkedListImpl<E> implements LinkedList<E> {

    private int size = 0;

    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E element) {
        //Adds element to the list
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        //Return an element for the given index
        //Should throw IndexOutOfBoundsException if index is negative or index is greater then number of elements in the list
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        int i = 0;
        while (i++ < index) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public boolean contains(E element) {
        //Checks if an element is present in the list
        Node<E> current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean delete(E element) {
        if (head == null) {
            return false;
        }
        if (head == tail) {
            clean();
            return true;
        }
        if (head.value.equals(element)) {
            head = head.next;
            return true;
        }
        Node<E> deletedNode = head;
        while (deletedNode.next != null) {
            if (deletedNode.next.value == element) {
                if (tail == deletedNode.next) {
                    tail = deletedNode;
                }
                deletedNode.next = deletedNode.next.next;
                size--;
                return true;
            }
            deletedNode = deletedNode.next;
        }
        return false;
    }

    @Override
    public E delete(int index) {
        //Deletes element from the list and returns removed element
        //Should throw IndexOutOfBoundsException if index is negative or index is greater then number of elements in the list
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        int i = 0;
        while (i++ < index) {
            current = current.next;
        }
        delete(current.value);
        return current.value;
    }

    @Override
    public boolean isEmpty() {
        //Checks if the list is empty
        return head == null;
    }

    @Override
    public int size() {
        //Returns the size of the list
        return this.size;
    }

    @Override
    public int clean() {
        //Cleans the list and returns the number of removed elements
        int oldSize = size;
        size = 0;
        head = null;
        tail = null;
        return oldSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl<>(head);
    }

    private static class IteratorImpl<E> implements Iterator<E> {

        private Node<E> node;

        public IteratorImpl(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E value = node.value;
            node = node.next;
            return value;
        }
    }
}