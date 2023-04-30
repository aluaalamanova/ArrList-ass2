
public class Main {
    public static void main(String[] args) {
        MyArrayListQueue<Integer> list = new MyArrayListQueue<>();
        list.enqueue(6);
        list.enqueue(9);
        list.enqueue(3);
        list.enqueue(5);
        list.enqueue(8);
        System.out.println(list.peek());
        list.dequeue();
        System.out.println(list.peek());
    }
}
