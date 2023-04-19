
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        list.add(2);
        list.add(3);

        list.add(4,2);
        System.out.println(list.size());
        System.out.println(list.size());
        System.out.println(list.get(2));

    }
}
