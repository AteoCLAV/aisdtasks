package task2;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.removeDuplicates();
        list.printList(); // Output: hello -> world -> again -> null
    }
}
