package Set;

import java.util.HashSet;
import java.util.Set;

public class MultiTheory {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();

        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        //Union объединение множеств

        //addAll() добавляет все элементы из сета указанного в аргументах в сет на котором вызвана команда
        //set1.addAll(set2);

        Set<Integer> union = new HashSet<>(set1);// создали новый сет на базе сет1. в юнион все числа сет1 есть уже

        union.addAll(set2);
        System.out.println(union);

        // intersection(пересечение) retainAll() оставляет в сет1 все элементы которые есть в сет2

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);

        // difference - разность множеств/ removeAll()-удаляет из сет1 все элементы которые есть и в сет 2

        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);



    }
}
