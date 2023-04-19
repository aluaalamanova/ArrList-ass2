import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list= new MyLinkedList<>();

        list.add("alua");
        list.add("daniya");
        list.add("elya");
        for (int i=0; i<list.getsize();i++){
            System.out.println(list.get(i) + " ");
        }



    }
}
