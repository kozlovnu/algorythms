public class Seminar3_1 {

    public class LinkedList {

        private Node head;
        private Node tail;

        public void add(int value) {
            Node node = new Node();
            node.value = value;
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
                node.previous = null;
            }
        }

        public void deleteFirst() {
            head = head.next;
            head.previous = null;
        }

        public Node find(int value) {
            Node node = head;
            while (node != null) {
                if (node.value == value) {
                    return node;
                }
                node = node.next;
            }
            return new Node();
        }

        public void addLast(int value) {
            Node node = new Node();
            node.value = value;
            tail.next = node;
            node.previous = tail;
            tail = node;
        }

        public void deleteLast() {
            Node headNode = tail.previous;
            headNode.next = new Node();
            tail = headNode;
        }

        public void bubblesort() {
            boolean finish = true;
            do {
                Node node = head;

                finish = true;
                while (node.next != null) {
                    if (node.value > node.next.value) {
                        int temp = node.value;
                        node.value = node.next.value;
                        node.next.value = temp;

                        finish = false;
                    }
                    node = node.next;
                }

            } while (!finish);
        }

        public void sortList()
	    {
	        Node current = head, index = new Node();
	        int temp;
	 
	        if (head == null) {
	            return;
	        }
	        else {
	            while (current != null) {
	                index = current.next;
	                while (index != null) {
	                    if (current.value > index.value) {
	                        temp = current.value;
	                        current.value = index.value;
	                        index.value = temp;
	                    }
	 
	                    index = index.next;
	                }
	                current = current.next;
	            }
	        }
	    }

        public class Node {
            int value;
            Node next;
            Node previous;
        }
    }
}
