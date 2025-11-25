package deque;
import java.lang.reflect.Array;

public class ArrayDeque<T> {
    T[] array;
    int size;
    int nextFirst;
    int nextLast;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }
    public void addFirst(T item){
        if(nextFirst == nextLast){
            resize(size*2);
        }
        array[nextFirst] = item;
        nextFirst = (nextFirst + array.length - 1) % array.length;
        size += 1;
    }

    public void addLast(T item){
        if(nextFirst == nextLast){
            resize(size*2);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % array.length;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i=nextFirst+1;i % array.length != nextLast - 1;i++){
            System.out.print(array[i % array.length] + " ");
        }
        System.out.print("\n");
    }

    public T get(int index){
        return array[(nextFirst + index + 1) % array.length];
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        for(int i=0;i<nextLast;i++){
            a[i] = array[i];
        }
        for(int i = nextFirst;i < array.length;i++){
            a[capacity - array.length + i] = array[i];
        }
        nextFirst = capacity - array.length + nextLast;
        array = a;
    }


}
