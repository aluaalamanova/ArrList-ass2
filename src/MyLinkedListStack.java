import java.util.EmptyStackException;
public class MyLinkedListStack<T>{
    private MyLinkedList<T> linkedList;
    public MyLinkedListStack() {
        linkedList= new MyLinkedList<>();
    }
    /**
     * Adds an element to the top of the stack.
     * @param element the element to be added to the stack.
     */
    public void push(T element) {
        linkedList.addFirst(element);
    }

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return linkedList.removeFirst();
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @return the element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return linkedList.getFirst();
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    public int size() {
        return linkedList.size();
    }
}