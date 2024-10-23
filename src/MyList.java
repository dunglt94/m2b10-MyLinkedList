public class MyList<E> {
    private Node head;
    private Node tail;

    private int numNodes = 0;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyList(Object data) {
        head = new Node(data);
        tail = head;
        numNodes++;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
        if (tail == null) tail = head;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public void add (int index, E element) {
        checkIndex(index);
        if (index == 0) addFirst(element);
        else if (index >= numNodes) addLast(element);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
        }
        numNodes++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        Node temp;
        Node current = head;

        if (numNodes == 1) {
            temp = head;
            head = null;
        } else if (index == 0) {
            temp = head;
            head = head.next;
        } else if (index == numNodes - 1) {
            while (current.next.next != null) {
                current = current.next;
            }
            temp = current.next;
            current.next = null;
        } else {
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            temp = current.next;
            current.next = temp.next;
        }
        numNodes--;
        return (E) temp.getData();
    }

    public boolean remove(Object e) {
        Node current = head;
        if (head == null) return false;
        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        } else if (tail.data.equals(e)) {
            while (current.next.next != null) {
                current = current.next;
            }
            tail = current;
            current.next = null;
            numNodes--;
            return true;
        }
        while (current.next != null) {
            if (current.next.data.equals(e)) {
                current.next = current.next.next;
                numNodes--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public int size() {
        return numNodes;
    }


    @SuppressWarnings("unchecked")
    public MyList<E> clone() {
        MyList<E> clone = new MyList<>(null);
        if (head == null) {
            return clone;
        }

        Node current = head;
        clone.head = new Node(current.getData());
        Node cloneCurrent = clone.head;

        while (current.next != null) {
            current = current.next;
            cloneCurrent.next = new Node(current.getData());
            cloneCurrent = cloneCurrent.next;
        }
        clone.tail = cloneCurrent;
        clone.numNodes = this.numNodes;
        return clone;
    }

    public boolean contains(E o) {
        if (head == null) return false;
        if (head.data.equals(o)) return true;
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(o)) return true;
            current = current.next;
        }
        return false;
    }

    public int indexOf(E o) {
        if (head == null) return -1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            if (current.next.data.equals(o)) return numNodes - 1;
        }
        return -1;
    }

    public boolean add(E o) {
        if (head == null) return false;
        Node newNode = new Node(o);
        newNode.next = head;
        head = newNode;
        numNodes++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        if (index == 0) return getFirst();
        if (index == numNodes - 1) return getLast();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.getData();
    }

    @SuppressWarnings("unchecked")
    public E getFirst() {
        if (head == null) return null;
        return (E) head.data;
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return (E) current.getData();
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


}
