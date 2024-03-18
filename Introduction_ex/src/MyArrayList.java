
public class MyArrayList<T> {

    private Object[] array;
    private int numElems;

    MyArrayList() {
        this.array = new Object[10];
        this.numElems = 0;
    }

    public int size(){
        return numElems;
    }

    public void add(T thing) {
        if (array.length == numElems) {
            Object[] temp = new Object[numElems * 2];
            for (int i = 0; i < numElems; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[numElems++] = thing;
    }

    private boolean outOfBoundsCheck(int i) {
        return i >= numElems || i < 0;
    }

    public T get(int i) {
        if (outOfBoundsCheck(i)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + i + " is out of bounds for MyArrayList of size " + numElems);
        }
        return (T) (array[i]);
    }

    public void remove(int x) {
        if(outOfBoundsCheck(x)){
            throw new IndexOutOfBoundsException("Index: " + x + " is out of bounds for MyArrayList of size " + numElems);
        }
        if(numElems - 1 < array.length / 2) {
            Object[] temp = new Object[array.length / 2];
            for (int i = 0; i < numElems; i++) {
                if (i != x) {
                    temp[i] = array[i];
                }
            }
            array = temp;
            numElems--;
        }
    }


}
