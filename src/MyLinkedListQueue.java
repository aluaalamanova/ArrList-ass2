import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    private MyLinkedList<T> list;
    public MyLinkedListQueue() {
        list = new MyLinkedList<T>();
    }
    public void enqueue(T element) {
        list.addLast(element);
    }
    public T dequeue() {
        return list.removeFirst();
    }
    public T peek() {
        return list.getFirst();
    }

}
