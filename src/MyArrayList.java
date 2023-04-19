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

