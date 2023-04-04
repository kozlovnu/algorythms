package HW;


public class RedBlackTree<V extends Comparable<V>> {

    private Node root;

    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, V value) {
        if (node.value == value) { // проверяем, есть ли уже такое значение в дереве
            return false; // если есть возвращаем false
        } else {
            if (node.value.compareTo(value) > 0) { // если значение ноды > value
                if (node.leftChild != null) { // проверяем не пустой ли левый ребенок
                    boolean result = addNode(node.leftChild, value); // рекурсивно вызываем addNode
                    node.leftChild = rebalance(node.leftChild); // проводим ребалансировку
                    return result;
                } else { // если левый ребенок пустой
                    node.leftChild = new Node(); // создаем новый объект node
                    node.leftChild.color = Color.RED; // красим его в красный цвет
                    node.leftChild.value = value; // записываем значение value
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = node.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild; // берем левого ребенка
        Node betweenChild = node.rightChild; // берем промежуточного ребенка - элемент, который будет менять своего
                                             // родителя
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color; // левый ребенок получает цвет своего родителя
        node.color = Color.RED; // корень, который опустился ниже становится красным
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private class Node {
        private V value;
        private Color color;
        private Node rightChild;
        private Node leftChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value = " + value +
                    ", color = " + color +
                    "}";
        }
    }

    private enum Color {
        RED, BLACK
    }

}
