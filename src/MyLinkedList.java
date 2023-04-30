public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    MyLinkedList() {

    }

    // Returns the number of elements in the list.
    @Override
    public int size() {
        return size;
    }

    // Returns true if the list contains the specified element, false otherwise.
    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Adds the specified element to the end of the list.
    @Override
    public void add(T newItem) {
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Returns the element at the specified position in the list.
    @Override
    public T get(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Inserts the specified element at the specified position in the list.
    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            MyNode<T> prev = new MyNode<>(get(index - 1));
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // Checks that the specified index is valid, and throws an exception if not.
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    // Removes the first occurrence of the specified element from the list, if it exists.
    @Override
    public boolean remove(T item) {
        MyNode<T> current = head;
        MyNode<T> previous = null;
        boolean check = false;
        while (current != null) {
            if (current.data.equals(item)) {
                check = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (check) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            if (current == tail) {
                tail = previous;
            }
            size--;
        }
        return check;
    }

    // Removes the element at the specified position in the list, and returns it.
    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        MyNode<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        if (current == tail) {
            tail = previous;
        }
        size--;
        return current.data;
    }

    // This method clears the linked list by setting the size to 0, and the head and tail to null.
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    // This method finds and returns the index of the first occurrence of the specified object in the linked list.
// If the object is not found, it returns -1.
    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // This method finds and returns the index of the last occurrence of the specified object in the linked list.
// If the object is not found, it returns -1.
    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int index = -1;
        int currentIndex = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                index = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return index;
    }

    // This method sorts the linked list in ascending order, assuming that the objects in the linked list implement the Comparable interface.
    @Override
    public void sort() {
        MyNode<T> current = head;
        while (current != null) {
            MyNode<T> min = current;
            MyNode<T> inner = current.next;
            while (inner != null) {
                if (((Comparable<T>) inner.data).compareTo(min.data) < 0) {
                    min = inner;
                }
                inner = inner.next;
            }
            if (min != current) {
                T temp = current.data;
                current.data = min.data;
                min.data = temp;
            }
            current = current.next;
        }
    }
    

    // This is a class that represents a node in the linked list.
    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }
}

