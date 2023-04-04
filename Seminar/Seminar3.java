package Seminar;
public class Seminar3 {

    public class LinkedList {
        private Node head;

        public void add(int value) {
            Node node = new Node();
            node.value = value;
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        public void delete() {
            head = head.next;
        }

        public Node find(int value){
            Node node = head;
            while(node != null){
                if (node.value == value){
                    return node;
                }
                node = node.next;                
            }
            return new Node();
        }

        public void addLast(int value){
            Node node = new Node();
            node.value = value;
            Node headNode = head;
            while (headNode.next != null){
                headNode = headNode.next;
            }
            headNode.next = node;
        }

        public void deleteLast(){
            Node headNode = head;
            while (headNode.next.next != null){
                headNode = headNode.next;
            }
            headNode.next = new Node();
        }

        public class Node {
            int value;
            Node next;
            Node previous;
        }
    }
}
