package LinkedList2;

import java.util.Arrays;

/**
 * Своя реализация LinkedList. Односвязный вариант. Разбор как он устроен
 */
public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        //если это первое добавление в список
        if (head == null) {
            this.head = new Node(value);// если пустой создаем новый узел и передаем ему значение

        } else {// иначе если добавление не первое должны дойти до конца списка и нашему последнему узлу
            // в качестве узла указать новый узел с нашим значением
            Node temp = head;//временному узлу указываем наш хед списка

            while (temp.getNext() != null) {//крутимся до конца списка тк некст елемент не null
                // и выйдем из цикла с переменной temp указывающей на последний элемент в нашем списке
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));//последнему узлу в качестве следующего узла назначим новый узел
            // и ему в качестве значения передадим то что было передано в метод add

        }
        size++;
    }

    //реализуем метод get в нашем list
    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {//пока не null идем по цепочке. присваиваем переменной temp следующее значение
            if (currentIndex == index) {//если находимся на искомом индексе
                return temp.getValue();//то берем текущий узел и возвращаем его значение
            } else {
                temp = temp.getNext();// если не равняется искомому то идем дальше инкриментируя currentIndex
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();// не нашли значение
        // значит индекс поданный в аргументы больше чем размер нашего списка
    }

    public void remove(int index) {
        if (index == 0) {//удаляем первый элемент в списке. хед переносится на следующий элемент
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index -1) { // [1]->[2]->[3]->null если индекс 2 то мы находясь на 1 элементе можем удалить 2
                temp.setNext(temp.getNext().getNext());//назначаем узлу 1 следующим узел 3,а не 2. и так 2 удаляется
                size--;//после удаления элемента дикриментируем список по размеру и выходим из метода
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }

    }


    public String toString() {//должны пройтись по нашему односвязному списку и куда-то записать каждый элемент
        int[] result = new int[size];// временный массив равняющийся размеру нашего списка

        int idx = 0;
        Node temp = head;
        while (temp != null) {// крутимся пока переменная временная temp не равняется null
            result[idx++] = temp.getValue();//и каждый раз в массив добавляем новое значение узла текущего
            temp = temp.getNext();
        }
        return Arrays.toString(result);

    }

    private static class Node {
        private int value;// значение, которое хранится в текущем узле
        private Node next;//ссылка на следующий узел

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
