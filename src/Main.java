
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        lis.add(2);
        lis.add(3);
        lis.add(8);
        lis.remove(2);

        for (int i=0; i<lis.size();i++) {
            System.out.println(lis.get(i) + " ");
        }


    }
}
