package implementations;
import interfaces.AbstractQueue;
import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY=10;
    private  int  rear;
    private final E[] queue;
    public Queue(){
        rear = -1;
        queue = (E[]) new Object[DEFAULT_CAPACITY];
    }
    @Override
    public void offer(E element) {
        if (rear == queue.length-1){
            throw new IllegalStateException("Queue Overflow!!");
        }
        queue[++rear] = element;
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = queue[0];
        for (int i=0;i<rear;i++){
            queue[i] = queue[i+1];
        }
        rear--;
        return element;
    }

    private void ensureNonEmpty() {
        if (rear==-1){
            throw new IllegalStateException("Queue is Empty");
        }

    }
    public String toString(){
        int current = 0;
        StringBuilder result = new StringBuilder();
        while(current<=rear){
            result.append(queue[current]).append("\n");
            current++;
        }
        return result.toString();
    }
    @Override
    public E peek() {
        ensureNonEmpty();
        return queue[0];
    }

    @Override
    public int size() {
        return rear+1;
    }

    @Override
    public boolean isEmpty() {
        return rear==-1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<=rear;
            }

            @Override
            public E next() {
                return queue[index++];
            }
        };
    }
}