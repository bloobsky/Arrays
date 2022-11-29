import java.util.*;

public class GenericArrayList<T> implements IList<T>{
    
    private T[] buffer;

    public GenericArrayList() {
        int list_size = 0;
        buffer = (T[]) new Object[list_size]; // initialing new object with the size

    }

    @Override
    public void add(T element) {
        T[] temporary = (T[]) new Object[buffer.length+1]; // increasing value
        int i = 0;

        for (i = 0; i<buffer.length; i++) {
            temporary[i] = buffer[i];
        }
        temporary[i] = element;
        buffer = temporary;

    }
    
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException{
        IndexCheck(index);
        T[] temporary = (T[]) new Object[buffer.length+1];

        for(int i = temporary.length-1; i>=0; i--) {
            if (i == index) {
                temporary[i] = element;
                i--;
                if(i<0) break; // skipping
            }
            temporary[i] = buffer[i-1];
        }
        buffer = temporary;
    }

}
