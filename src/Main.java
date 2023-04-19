
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        lis.add(2);
        lis.add(3);
        lis.add(8);

        System.out.println(lis.lastIndexOf(8));

    }
}
