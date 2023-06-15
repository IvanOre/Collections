package Iterable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *То что дает Джаве понять что это коллекция,по ней можно проходится,это и есть интерфейс Iterable
 * Все классы коллекции реализуют этот интерфейс
 * Итератор в себе хранит указатель,когда первый раз получаем итератор,указатель указывает место до первого объекта
 * И когда вызываем next() указатель двигается на единицу вправо(итерируется) пока есть hasNext()(следующий элемент)
 * В итераторе мы можем удалять элементы одновременно итерируя по ним
 * remove() в итераторе не принимает в аргументы элемент тк мы можем удалить только тот элемент,на котором
 * находится указатель
 *
 *
 * ДЛЯ for each допустим это нельзя. тк удалив элемент,цикл будет не понимать что нам показать дальше.
 * Старую версию с удаленным элементом или новую уже без него. Просто запретили изменять list в for each
 */
public class Test {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Раньше работало вот так до 5 JAVA
        int idx = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (idx == 1)//если переменная idx = 1 элементу в списке

                iterator.remove();// удаляем его
            idx++;
        }
        System.out.println(list);


        // JAVA 5
        for (int x : list)
            System.out.println(x);

    }
}
