# Ass2-arrList
### MyArrayList class
This class is an implementation of the MyList<T> interface, which provides a list data structure that can hold elements of any type T. The class uses an array to store the elements and dynamically increases the size of the array as needed.
### Fields
  T[] arr: an array to store elements.
  
  int size: the size of the list.
  ### Methods
void add(T element): adds an element to the end of the list.
  
void add(T element, int index): adds an element at a specific index.
  
boolean contains(Object o): checks if an element is present in the list.
  
T get(int index): gets the element at a specific index.
  
int indexOf(Object o): gets the index of the first occurrence of an element in the list.
  
int lastIndexOf(Object o): gets the index of the last occurrence of an element in the list.
  
int size(): gets the size of the list.
  
void clear(): removes all elements from the list.
  
boolean remove(T item): removes the first occurrence of an element from the list.
  
T remove(int index): removes the element at a specific index.
  
void increaseBuffer(): increases the buffer size of the array.
  
  ### Solution
    
    public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public void  add(T element){
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }
    @Override
    public void add(T element, int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size==arr.length){
            increaseBuffer();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }
    @Override
    public int indexOf(Object o){
        for (int i = 0; i<size; i++){
            if (arr[i]==o){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = null;
        size--;
        return true;
    }
    @Override
    public T remove(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
        return null;
    }
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) arr[j];
                Comparable<T> b = (Comparable<T>) arr[j + 1];
                if (a.compareTo((T) b) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = (T)temp;
                }
            }
        }
    }


    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}
  
  ### MylinkedList class
  MyLinkedList is an implementation of the MyList interface, which represents a singly linked list that can store elements of any type T. It provides methods to add, remove, and retrieve elements from the list, as well as sort the list in ascending order.
  ### Fields
  head: A reference to the first node in the linked list.
  
tail: A reference to the last node in the linked list.
  
size: The number of elements in the linked list.
  ### Methods
  size() : int : Returns the number of elements in the list.

contains(Object o) : boolean : Returns true if the list contains the specified element, false otherwise.

add(T newItem) : void : Adds the specified element to the end of the list.

get(int index) : T : Returns the element at the specified position in the list.

add(T item, int index) : void : Inserts the specified element at the specified position in the list.

remove(T item) : boolean : Removes the first occurrence of the specified element from the list, if it exists.

remove(int index) : T : Removes the element at the specified position in the list, and returns it.

clear() : void : Clears the linked list by setting the size to 0, and the head and tail to null.

indexOf(Object o) : int : Finds and returns the index of the first occurrence of the specified object in the linked list. If the object is not found, it returns -1.

lastIndexOf(Object o) : int : Finds and returns the index of the last occurrence of the specified object in the linked list. If the object is not found, it returns -1.

sort() : void : Sorts the linked list in ascending order, assuming that the objects in the linked list implement the Comparable interface.
  
  ### Solution
    public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    MyLinkedList() {

    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data==o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public void add (T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if (head == null) {
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail=newNode;
        }
        size++;
    }
    @Override
    public T get(int index){
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public void add(T item, int index){
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            MyNode<T> prev = new MyNode<>(get(index-1));
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public boolean remove(T item) {
        MyNode<T> current = head;
        MyNode<T> previous = null;
        boolean check = false;
        while (current != null) {
            if (current.data.equals(item)) {
                check = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (check) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            if (current == tail) {
                tail = previous;
            }
            size--;
        }
        return check;
    }
    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        MyNode<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        if (current == tail) {
            tail = previous;
        }
        size--;
        return current.data;
        }


    @Override
    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }
    @Override
    public int indexOf(Object o) {
        int index = 0;
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int index = -1;
        int currentIndex = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                index = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return index;
    }
    @Override
    public void sort() {
        MyNode<T> current = head;
        while (current != null) {
            MyNode<T> min = current;
            MyNode<T> inner = current.next;
            while (inner != null) {
                if (((Comparable<T>)inner.data).compareTo(min.data) < 0) {
                    min = inner;
                }
                inner = inner.next;
            }
            if (min != current) {
                T temp = current.data;
                current.data = min.data;
                min.data = temp;
            }
            current = current.next;
        }
    }

    private static class MyNode<E> {
        E data;
        MyNode<E> next;

        MyNode(E data) {
            this.data = data;
        }
    }


}
  
  
  
  ### MyList Interface which was implemented
  
    
  
    public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}  
