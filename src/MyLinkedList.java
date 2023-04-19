public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    MyLinkedList() {

    }
    public int size() {
        return size;
    }
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

    public T get( int index){
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }


}
