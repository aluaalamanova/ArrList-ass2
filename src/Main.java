
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        lis.add(9);
        lis.add(4);
        lis.add(1);
        lis.add(6);
        for (int i=0; i<lis.size();i++) {
            System.out.println(lis.get(i) + " ");
        }
        System.out.println(list.lastIndexOf(6));
        System.out.println(list.indexOf(6));


    }
}
