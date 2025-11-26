package deque;
import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayDeque <T> implements Iterable<T>{
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
        if(capacity > array.length){
            for(int i=0;i<nextLast;i++){
                a[i] = array[i];
            }
            for(int i = nextFirst;i < array.length;i++){
                a[capacity - array.length + i] = array[i];
            }
            nextFirst = capacity - array.length + nextLast;
        }else{
            for(int i=0; i < size;i++){
                a[i] = array[(nextFirst + i + 1) % array.length];
            }
            nextFirst = capacity - 1;
            nextLast = size;
        }
        array = a;

    }

    public T removeFirst() {
        if(size == 0){
            return null;
        }
        if(size < array.length / 4){
            resize(array.length / 4);
        }
        T item = array[(nextFirst+1) % array.length];
        array[(nextFirst+1) % array.length] = null;
        nextFirst = (nextFirst + 1) % array.length;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if(size == 0){
            return null;
        }
        if(size < array.length / 4){
            resize(array.length / 4);
        }
        T item = array[(nextLast-1 + array.length) % array.length];
        array[(nextLast-1 + array.length) % array.length] = null;
        nextLast  = (nextLast-1 + array.length) % array.length;
        size -= 1;
        return item;
    };

    private class DequeIterator implements Iterator<T> {
        private int idx;

        public DequeIterator(){
            idx = nextFirst;
        }

        public boolean hasNext() {
            return (idx+1)% array.length != nextLast;
        }

        public T next(){
            idx = (idx + 1)% array.length;
            return array[idx];
        }
    }

    public Iterator<T> iterator(){
        return new ArrayDeque<T>.DequeIterator();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ArrayDeque od){
            if(this.size == od.size){
                Iterator<T> tmp = od.iterator();
                for(T i : this){
                    if(i != tmp.next())
                        return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }
}


