package task2;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addFirst("hello");
        list.addFirst("world");
        list.addFirst("hello");
        list.addFirst("again");
        list.addFirst("hello");
        list.addFirst("world");
        list.removeDuplicates();
        list.printList(); // Output: hello -> world -> again -> null
    }
}
