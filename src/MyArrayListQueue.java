import java.util.NoSuchElementException;
public class MyArrayListQueue<T> {
    private MyArrayList<T> list;
    public MyArrayListQueue() {
        list = new MyArrayList<>();
    }
    public void enqueue(T element){
        list.add(element);
    }
    public T dequeue(){
        return list.remove(0);
    }
    public T peek(){
        return list.get(0);
    }
    public boolean isEmpty(){
        if (list.size()==0){
            return true;
        }
        return false;
    }

}
