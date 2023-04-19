public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    MyLinkedList() {

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


    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }
    public int size() {
        return size;
    }


}
