public class MyVector <E> extends MyAbstractList {
    public Object [] array;
    public static final int INITIAL_CAPACITY = 10;
    public int size;
    public int capacity;
    public int increment;

    @SuppressWarnings("unchecked")
    public MyVector(){
        array = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
        increment = 0;
    }

    @SuppressWarnings("Unchecked")
    public MyVector(int capacity){
        array = (E[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
        increment = 5;
    }

    @SuppressWarnings("Unchecked")
    public MyVector (int capacity, int increment){
        array = (E[]) new Object[capacity];
        this.increment = increment;
        size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getIncrement() {
        return increment;
    }

    public boolean add(Object data) {

           if (size == array.length){
               Object[] temp = new Object[2 * array.length];

               for (int i = 0; i < size; i++) {
                   temp[i] = array[i];
               }
               array = temp;
           }
           array[size++] = data;

        return true;
    }

    public boolean add(int index, Object data) {
       if (size == array.length || index < 0 || index > size -1){
           return false;
       }
       for (int i = size - 1; i >= index; i--) {
           array[i + 1] = array[i];
       }
       array [index] = data;
       size++;

        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        return array[index];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public Object remove(int index) throws Exception {
        Object temp = array[index];
        while (index < size - 1) {
            array[index] = array [index + 1];
            index++;
        }
        array[--size] = null;
        return temp;
    }

   
    public void trimToSize() {
        Object[] temp = new Object[size];
        for (int i = 0; i <size;i++){
            temp[i] = array [i];
        }
        capacity = size;
        array = temp;
    }
    public String toString() {
        String s = "[";
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                s += array[i] + ", ";
                s += array[size - 1];
            }
        }
        return s += "]";
    }
}
