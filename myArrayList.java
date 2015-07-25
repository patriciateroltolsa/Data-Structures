/*
 * Author: Patricia Terol
 * Project: interface
 * This program implements the ArrayList API using created methods and arrays.
 */
 
import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyArrayList extends AbstractList<Integer>{
    private static final int TEN = 10;
    private int[] array;

    // Constructs an empty list with an initial capacity of ten
    public MyArrayList() {
        array = new int[TEN];
    }

    // Constructs an empty list with the specified initial capacity
    public MyArrayList(final int initialCapacity) {
        array = new int[initialCapacity];
    }

    // Checks if the index given passed in the method is valid(within the range
    // of the array and not less than 0)
    private boolean checkRange (final int index) {
        if (array.length >= index || index < 0) {
            throw new IndexOutOfBoundsException ();
        }
        return true;
    }

    // Increases the capacity of the array, if necessary, to ensure that it can
    // hold at least the number of elements specified by the argument
    private void ensureCapacity (final int minCapacity) {
        if (array.length < minCapacity) {
            array = Arrays.copyOf (array, minCapacity);
        }
    }

    // Inserts the specified element at the end of the list, return true if it
    // succeeded
    public final boolean add (final Integer element) {
        try {
            ensureCapacity (array.length + 1);
            array[array.length - 1] = element;
        } catch (final OutOfMemoryError e) {
            return false;
        }
        return true;
    }

    // Insert a new element at the index provided. you should shift element
    // forward and the put element at index position.
    public final void add (final int index, final Integer v) {
        checkRange(index);
        ensureCapacity(array.length + 1);
        for(int y = 0; y < array.length - (index +1); y++){
            array[array.length- (y+1)] = array[array.length- (y+2)];
        }
        array[index] = v;
    }

    // Returns the element at the specified position in this list
    public final Integer get (final int index) {
        checkRange (index);
        return array[index];
    }

    // Replaces the element at the specified position in this list, should
    // return the removed element value
    public final Integer set (final int index, final Integer element) {
        checkRange (index);
        final int removed = array[index];
        array[index] = element;
        return removed;
    }

    // Removes the element at index specified by the argument, return the
    // removed element value.
    public final Integer remove (final int index) {
        checkRange (index);
        int[] temporal = null;
        final int removed = array[index];
        temporal = Arrays.copyOfRange (array, 0, index);
        for (int j = index + 1; j < array.length - 1; j++) {
            temporal[j - 1] = array[j];
        }
        array = temporal;
        return removed;
    }

    // Find and Remove the first occurrence of the specified element from this
    // list, if it is present.
    public final boolean remove (final Integer element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                remove (i);
                return true;
            }
        }
        return false;
    }

    // Returns the number of elements in this list
    public final int size () {
        return array.length;
    }

    // Removes all of the elements from this list.
    public final void clear () {
        array = null;
    }

    // Show the list in the same format as array list, e.g., [1, 2, 3, 4]
    public final String toString () {
        String result = "[";
        for(int i = 0; i< array.length; i++){
            result += array[i];
            result += ", ";
        }
        result = result.substring (0, result.length ()-2);
        result += "]";
        return result;
    }

    public static void main (final String[] args) {
    }
}
