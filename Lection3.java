public class Lection3 {
    Node head;
    Node tail;

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){
            next.previous = null;
            head = next;
        } else {
            if (next == null){
                previous.next = null;
                tail = previous;
            }
            else {
                previous.next = next;
                next.previous = previous;
            }
        }
        previous.next = next;
        next.previous = previous;
    }

    public void reverse (){
        Node curreNode = head;
        while (curreNode != null){
            Node next = curreNode.next;
            Node previous = curreNode.previous;
            curreNode.next = previous;
            if (previous == null){
                tail = curreNode;
            }
            if (next == null){
                head = curreNode;
            }
            curreNode.previous = next;
        }
    }

    // метод поиска
    public Node find(int value){
        Node currentNode = head;
        while(currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public class Node{
        int value;
        Node next;
        Node previous;
    }
}
