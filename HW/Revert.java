package HW;
public class Revert {
    public class LinkedList{

        private Node head;
        private Node tail;

        public void revert(){
            Node currentNode = head;
            while (currentNode != null){
                Node next = currentNode.nextNode;
                Node previous = currentNode.previousNode;
                currentNode.nextNode = previous;
                if (previous == null){
                    tail = currentNode;
                }
                if (next == null){
                    head = currentNode;
                }
                currentNode.previousNode = next;
            }
        }


        public class Node{
            int value;
            Node nextNode;
            Node previousNode;
        }
    }
}
