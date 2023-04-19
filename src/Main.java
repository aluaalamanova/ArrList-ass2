
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list= new MyArrayList<>();
        MyLinkedList<Integer> lis = new MyLinkedList<>();
        list.add(6);
        list.add(4,0);
        list.add(3,1);
        list.add(3,2);
        for (int i=0; i<list.size();i++) {
            System.out.println(list.get(i) + " ");
        }


    }
}
