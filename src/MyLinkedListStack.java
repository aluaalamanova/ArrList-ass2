import java.util.EmptyStackException;
public class MyLinkedListStack<T>{
    private MyLinkedList<T> linkedList;
    public MyLinkedListStack() {
        linkedList= new MyLinkedList<>();
    }
    public void push (T element){
        linkedList.add(element);
    }
    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return linkedList.remove(size() - 1);
    }
    public boolean isEmpty(){
        if (linkedList.size()==0){
            return true;
        }
        return false;
    }
    public int size(){
        return linkedList.size();
    }
}
