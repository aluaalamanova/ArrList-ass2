public class MyArrayList<T> implements MyList<T> {
    private T[] arr;  // array to store elements
    private int size; // size of the list

    // constructor
    MyArrayList() {
        // initialize array with initial capacity of 5 and size 0
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    // method to add element to the end of the list
    @Override
    public void add(T element) {
        // if array is full, increase the buffer
        if (size == arr.length) {
            increaseBuffer();
        }
        // add element to the end of the list and increment the size
        arr[size++] = element;
    }

    // method to add element at a specific index
    @Override
    public void add(T element, int index) {
        // check if index is valid
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // if array is full, increase the buffer
        if (size == arr.length) {
            increaseBuffer();
        }
        // shift all elements to the right of the index by one position
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        // add element at the specified index and increment the size
        arr[index] = element;
        size++;
    }

    // method to check if an element is present in the list
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) { // check if element at index i is equal to the object o
                return true;
            }
        }
        return false;
    }

    // method to increase the buffer size of the array
    public void increaseBuffer() {
        // create a new array with double the capacity of the current array
        T[] newArr = (T[]) new Object[arr.length * 2];
        // copy all elements from the current array to the new array
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        // replace the current array with the new array
        arr = newArr;
    }

    // method to get an element at a specific index
    @Override
    public T get(int index) {
        checkIndex(index); // check if index is valid
        return arr[index]; // return element at the specified index
    }

    // method to get the index of the first occurrence of an element in the list
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) { // check if element at index i is equal to the object o
                return i; // return the index of the element if found
            }
        }
        return -1; // return -1 if element not found
    }

    // method to get the index of the last occurrence of an element in the list
    @Override
    public int lastIndexOf(Object o) {
        // Search for last index of object 'o' in the list, starting from the end of the list
        if (o == null) {
            // If 'o' is null, search for last index of null in the list
            for (int i = size - 1; i >= 0; i--) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            // If 'o' is not null, search for last index of 'o' in the list
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(arr[i])) {
                    return i;
                }
            }
        }
        // If 'o' was not found in the list, return -1
        return -1;
    }

    @Override
    public int size() {
        // Return the size of the list
        return size;
    }

    @Override
    public void clear() {
        // Clear the list by reinitializing the internal array to a new array of size 5 and setting the size to 0
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public boolean remove(T item) {
        // Remove the first occurrence of 'item' from the list
        int index = indexOf(item);
        if (index == -1) {
            // If 'item' is not found in the list, return false
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            // Shift all elements after 'item' one position to the left
            arr[i] = arr[i + 1];
        }
        // Set the last element to null and decrement the size of the list
        arr[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public T remove(int index) {
        // Remove the element at the given 'index' from the list
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            // Shift all elements after 'index' one position to the left
            arr[i - 1] = arr[i];
        }
        // Decrement the size of the list and return null (the removed element is discarded)
        size--;
        return null;
    }

    @Override
    public void sort() {
        // Sort the list using bubble sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) arr[j];
                Comparable<T> b = (Comparable<T>) arr[j + 1];
                if (a.compareTo((T) b) > 0) {
                    // If element at index 'j' is greater than element at index 'j+1', swap them
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = (T) temp;
                }
            }
        }
    }
    public void sortSubArr( int m, int n){
        int subSize=n-m;
       for (int i=m-1; i<subSize-1; i++){
           for (int j=m-1; j<subSize-i-1; j++){
               Comparable<T> s =(Comparable<T>) arr[j];
               Comparable<T> k =(Comparable<T>) arr[ j +1];
             if (s.compareTo((T) k)>0){
                Object temp = arr[j];
                arr[j]= arr[j+1];
                arr[j+1]= (T) temp;
             }
                   }
       }

    }

    public void checkIndex(int index) {
        // Check if index is within the bounds of the list, and throw an exception if it is not
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}