import java.util.EmptyStackException;

public class MyArrayListStack<T> {
    private MyArrayList<T> list;

    public MyArrayListStack() {
        list = new MyArrayList<T>();
    }
    public void push(T element) {
        list.add(element);
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }
    public boolean isEmpty() {
        if (list.size()==0){
            return true;
        }
        return false;
    }
}