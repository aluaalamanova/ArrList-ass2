
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        lis.add(2);
        lis.add(10);
        lis.add(8);
        lis.add(5);
        lis.sort();
        for (int i=0; i<lis.size();i++) {
            System.out.println(lis.get(i) + " ");
        }


    }
}
