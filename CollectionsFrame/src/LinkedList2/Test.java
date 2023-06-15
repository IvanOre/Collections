package LinkedList2;

import java.util.LinkedList;
import java.util.List;

/**
 * Есть 2 вида связных списков.
 * Односвязный список и двусвязный список.
 *
 * Односвязный head-->[5]--->[7]--->[3]--->[4]---> null.У односвязного есть ссылка только на следующий узел
 *
 *
 *
 * Двусвязный head<----->[5]<---->[7]<--->[3]<---->[4]---> null Есть ссылка на следующий узел и на предыдущий
 * Он более эффективен. Может проходиться с двух сторон списка.
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(10);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);



    }
}
