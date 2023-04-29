import java.util.EmptyStackException;
public class MyLinkedListStack<T>{
    private MyLinkedList<T> linkedList;
    public MyLinkedListStack() {
        linkedList= new MyLinkedList<T>();
    }
    public void push (T element){
        linkedList.add(element);
    }
    public T pop(){
        return linkedList.remove(linkedList.size() - 1);
    }
    public boolean isEmpty(){
        if (linkedList.size()==0){
            return true;
        }
        return false;
    }
}
