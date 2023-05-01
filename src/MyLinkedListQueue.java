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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
    }

    public int size() {
        return list.size();
    }

}
