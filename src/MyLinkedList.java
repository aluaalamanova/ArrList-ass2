public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    MyLinkedList() {

    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data==o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public void add (T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail=newNode;
        }
        size++;
    }
    @Override
    public T get(int index){
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public void add(T item, int index){
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
            MyNode<T> prev = new MyNode<>(get(index-1));
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
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


    @Override
    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }
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
    @Override
    public void sort(){

    }
    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }


}
