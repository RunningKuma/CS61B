package deque;

public class LinkedListDeque<T> {
    private Node<T> sentinel;
    int size ;

    public class Node<T>{
        public T item;
        public Node<T> prev;
        public Node<T> next;

        public Node(T item){
            this.item = item;
            this.prev = null;
            this.next = null;
        }
        public Node(){
            this.item = null;
            this.prev = null;
            this.next = null;
        }
    }

    public LinkedListDeque(){
        this.sentinel = new Node<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        this.size = 0;
    }

    public void addFirst(T item){
        Node<T> new_item = new Node<T>(item);
        Node<T> old_First = sentinel.next;
        if(old_First == sentinel){
            new_item.next = new_item;
            new_item.prev = new_item;
            sentinel.next = new_item;
        }else{
            new_item.next = sentinel.next;
            sentinel.next = new_item;
            new_item.prev = old_First.prev;
            old_First.prev = new_item;
        }

        size += 1;
    }

    public void addLast(T item){
        Node<T> new_item = new Node<>(item);
        Node<T> old_Last = sentinel.next.prev;
        if(old_Last == sentinel){
                new_item.next = new_item;
                new_item.prev = new_item;
                sentinel.next = new_item;
        }else{
            old_Last.next = new_item;
            new_item.prev = old_Last;
            new_item.next = sentinel.next;
            sentinel.next.prev = new_item;
        }
        size += 1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int n = 0;
        Node<T> tmp = sentinel.next;
        System.out.print(tmp.item + " ");
        tmp = tmp.next;
        while(tmp != sentinel.next){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println("\n");
    }

    public T removeFirst(){
        if(size != 0){
            Node<T> first = sentinel.next;
            sentinel.next = first.next;
            sentinel.next.prev = first.prev;
            first.prev.next = sentinel.next;
            size -= 1;
            return first.item;
        }
        else{
            return null;
        }
    }

    public T removeLast(){
        if(size != 0){
            Node<T> last = sentinel.next.prev;
            last.next.prev = last.prev;
            last.prev.next = sentinel.next;
            size -= 1;
            return last.item;
        }
        else{
            return null;
        }
    }

    public T get(int index){
        int n=0;
        Node<T> tmp = sentinel;
        while(n != index){
            tmp = tmp.next;
            n++;
        }
        return tmp.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node<T> p, int i) {
        if (i == 0) {
            return p.item;
        }

        return getRecursiveHelper(p.next, i - 1);
    }


}
