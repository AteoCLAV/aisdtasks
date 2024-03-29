package task2;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private class LinkListItem<T> {
        public T value;
        public LinkListItem<T> next;
        public LinkListItem<T> prev;

        public LinkListItem(T value, LinkListItem<T> next, LinkListItem<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public LinkListItem(T value) {
            this(value, null, null);
        }

        public LinkListItem() {
            this(null, null, null);
        }
    }


    private LinkListItem<T> head = null;
    private LinkListItem<T> tail = null;
    private int count = 0;


    private void checkEmpty() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
    }

    public T getFirst() throws Exception {
        checkEmpty();
        return head.value;
    }

    public T getLast() throws Exception {
        checkEmpty();
        return tail.value;
    }

    private LinkListItem<T> getItem(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Incorrect index");
        }
        LinkListItem<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getItem(index).value;
    }

    public void addFirst(T value) {
        head = new LinkListItem<>(value, head, null);
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        if (tail == null) {
            head = tail = new LinkListItem<>(value, null, null);
        } else {
            tail = tail.next = new LinkListItem<>(value, null, tail);
        }
        count++;
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index > count) {
            throw new Exception("Incorrect index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            LinkListItem<T> prev = getItem(index - 1);
            prev.next = new LinkListItem<>(value, prev.next, prev);
            if (prev.next.next == null) {
                tail = prev.next;
            }
            count++;
        }
    }

    public T removeFirst() throws Exception {
        checkEmpty();
        T value = getFirst();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return value;
    }

    public T removeLast() throws Exception {
        return remove(count - 1);
    }

    public T remove(int index) throws Exception {
        if (index == 0) {
            return removeFirst();
        } else {
            LinkListItem<T> prev = getItem(index - 1);
            T value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            count--;
            return value;
        }
    }

    public void printList() {
        LinkListItem<T> prev = head;
        while (prev != null) {
            System.out.print(prev.value+ " ");
            prev = prev.next;
        }
    }
    public LinkList<T> removeDuplicates() {
        LinkListItem<T> current = tail;
        LinkListItem<T> prev = current.prev;
        while (current != null) {
            if (this.contains(current)) {
               current.prev = current.next;
               prev.next = current;
            }
            if (current.prev == null) {
                System.out.println();
            }
                current = prev;
                if (prev != null) {
                    prev = prev.prev;
                }
        }
        return this;
    }
    public boolean contains(LinkListItem<T> value) {
        LinkListItem<T> current =tail;
        while (current != null) {
            if (current.value.equals(value.value) && current != value) {
                return true;
            }
            current = current.prev;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkListItem<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }
}
