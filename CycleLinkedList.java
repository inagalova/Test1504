class Node<T>
{
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    public Node(T data)
    {
        this(data, null);
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getNext()
    {
        return next;
    }
}

public class CycleLinkedList<T> implements ICycleLinkedList<T>{
    private Node<T> start;
    private Node<T> end;
    private int size;

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        if(isEmpty())
        {
            start = new Node<T>(element);
            end = start;
            size++;
            return;
        }
        end.setNext(new Node<T>(element));
        end = end.getNext();
        end.setNext(start);
        size++;
    }

    @Override
    public void addAtIndex(int index, T element) {
        if(index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = start;
        Node<T> previousNode = null;
        while(index > 0)
        {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            index--;
        }
        if(previousNode != null)
        {
            Node<T> newElement = new Node<T>(element, currentNode);
            previousNode.setNext(newElement);
            if (previousNode == end) {
                end = newElement;
                end.setNext(start);
            }
            //index++;
        }
        else
        {
            start = new Node<T>(element, start);
            end.setNext(start);
        }
        size++;
    }

    @Override
    public void clear() {
        start = end = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (!isEmpty()) {
            index = index % size;
        }
        if (index < 0) {
            index += size;
        }
        Node<T> stack = start;
        while (index < 0) {
            stack = stack.getNext();
            index++;
        }
        while(index > 0)
        {
            stack = stack.getNext();
            index--;
        }
        return stack.getData();
        }
    }
