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
        return list.remove(list.size() - 1);
    }

}