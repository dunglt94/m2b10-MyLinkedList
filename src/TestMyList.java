public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(4);
        System.out.println("Added 2 " + myList.add(2));
        myList.addFirst(1);
        myList.add(2, 3);
        myList.addLast(5);
        myList.printList();

        System.out.println("Removed " + myList.remove(3));
        System.out.println("Removed 5? " + myList.remove((Object) 5));
        myList.printList();

        System.out.println("List size: " + myList.size());

        System.out.println("Test clone:");
        MyList<Integer> clone = myList.clone();
        clone.addLast(7);
        clone.printList();
        System.out.println("Original list: ");
        myList.addLast(6);
        myList.printList();

        System.out.println("containt 6? " + myList.contains(6));
        System.out.println("index of 6? " + myList.indexOf(6));
        System.out.println("element at index 2:  " + myList.get(2));
        System.out.println("head element: " + myList.getFirst());
        System.out.println("tail element: " + myList.getLast());




    }
}
