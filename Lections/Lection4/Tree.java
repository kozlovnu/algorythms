package Lections.Lection4;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    // метод обхода в ширину

    private Node find(int value){
        List <Node> line = new ArrayList<>();                   // создаем лист горизонтальных нод
        line.add(root);                                         // добавляем корневую ноду
        while (line.size() > 0){                                // пока размер листа больше 0
            List <Node> nextLine = new ArrayList<>();           // создаем еще один лист, в который будем записывать детей
            for (Node node : line) {                            // проходим по всем элементам списка line
                if (node.value == value){                       // если находим значение
                    return node;                                // возвращаем эту ноду
                }
                nextLine.addAll(node.children);                 // иначе добавляем в nextLine детей текущей ноды
            }
            line = nextLine;                                    // перезаписываем в line = nextLine
        } 
        return null;
    }

    // метод обхода в глубину
    public boolean exists(int value){               // метод проверки существования value в tree
        if (root != null){                          // проверяем сущетсвует ли root
            Node node = find(root, value);          // вызываем функцию поиска
            if (node != null){                      // если нода не null
                return true;                        // возвращаем true
            }
        }
        return false;                               // если не нашли возвращаем false
    }

    private Node find(Node node, int value) {
        if (node.value == value) {                  // если значение ноды = value
            return node;                            // возвращаем эту ноду
        } else {                                    // в противном случае
            for (Node child : node.children) {      // в цикле foreach перебираем детей
                Node result = find(child, value);   // рекурсивно для каждого ребенка вызываем функцию поиска
                if (result != null) {               // если result не null
                    return result;                  // возвращаем найденную ноду
                }
            }
        }
        return null;                                // в остальных случаях возвращаем null
    }

    public class Node {
        int value;
        List<Node> children;
    }
}
