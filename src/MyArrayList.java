public class MyArrayList<T> {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    public void  add(T element){
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

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

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }
    public int indexOf(Object o){
        for (int i = 0; i<size; i++){
            if (arr[i]==o){
                   return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    public void remove(int index){
        checkIndex(index);
        for(int i= index + 1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}