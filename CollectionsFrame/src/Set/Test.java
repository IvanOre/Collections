package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SET-коллекция которая хранит в себе только уникальные элементы(без дубликатов).В отличии от хешмап
 * Чаще используется HashSet тк он наиболее быстрый и нам часто не нужно порядка
 * альт+шифт и выбрать строки для редактирования всех сразу
 *
 *
 * contains() в set работает очень быстро тк используется хеширование. везде в сетах константное время
 * isEmpty()-возвращает true если сет пустой.false если нет
 * и много других методов смотрим в документации
 *
 *
 * Дубликаты элементов set игнорирует. выводит только первый добавленный "оригинал"
 *
 *
 * Sеt близок к математическому- Теория множеств
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();// не сохраняет никакого порядка элементов
        Set<String> linkedHashSet = new LinkedHashSet<>();// порядок добавления элементов
        Set<String> treeSet = new TreeSet<>();// сортировка естественным порядком от меньшего к большему и ЛГК

        //нет никакого порядка
        hashSet.add("Ivan");
        hashSet.add("Max");
        hashSet.add("Boris");
        hashSet.add("Anatoliy");
        hashSet.add("Denis");
        hashSet.add("Max");
        hashSet.add("Max");

       /* // В порядке добавления
        linkedHashSet.add("Ivan");
        linkedHashSet.add("Max");
        linkedHashSet.add("Boris");
        linkedHashSet.add("Anatoliy");
        linkedHashSet.add("Denis");

        // В естественном порядке(Лексико-графический порядок по Алфавиту)
        treeSet.add("Ivan");
        treeSet.add("Max");
        treeSet.add("Boris");
        treeSet.add("Anatoliy");
        treeSet.add("Denis");*/

        for (String name : hashSet){
            System.out.println(name);
        }

        System.out.println(hashSet);

 ////////////////////////Полезные методы для SET////////////////////////////////////////////////
        //contains()- позволяет узнать если ли такой элемент в сете или нет. boolean true or false

        System.out.println(hashSet.contains("Ivan"));
        System.out.println(hashSet.contains("Katy"));

        // isEmpty()-возвращает true если сет пустой.false если нет

        System.out.println(hashSet.isEmpty());



    }
}
