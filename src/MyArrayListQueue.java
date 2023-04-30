import java.util.NoSuchElementException;
public class MyArrayListQueue<T> {
    private MyArrayList<T> list;
    public MyArrayListQueue() {
        list = new MyArrayList<>();
    }
    /**
     * Adds an element to the back of the queue.
     * @param element the element to be added to the queue.
     */
    public void enqueue(T element){
        list.add(element);
    }

    /**
     * Removes and returns the front element of the queue.
     * @return the front element of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }

    /**
     * Returns the front element of the queue without removing it.
     * @return the front element of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty(){
        if (size()==0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue.
     */
    public int size(){
        return list.size();
    }
}




