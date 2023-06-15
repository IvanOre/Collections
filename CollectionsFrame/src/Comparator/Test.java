package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections.sort() стандартная сортировка в естественном порядке.
 *
 *
 * Что если хотим отсортировать в своем порядке?
 * Допустим по длине строк. ДЛя этого существует интерфейс Comparator
 *
 * Создаем новый класс и реализуем интерфейс Comparator с параметром который будем сортировать
 * Так же реализуем в нем метод compare и в нем описываем логику сравнивая строк между собой
 * В нем существует своя конвенция
 * o1 > o2 => 1. o1 < o2 => -1. o1 == o2 => 0. По числам джава понимает какой объект больше или меньше.
 *
 * class StringLengthComparator implements Comparator<String>{
 *
 *     @Override
 *     public int compare(String o1, String o2) {
 *         if (o1.length() > o2.length()){
 *             return 1;
 *         }else if (o1.length() < o2.length()){
 *             return -1;
 *         }else {
 *             return 0;
 *         }
 *
 *     }
 * }
 *  Collections.sort(animals, new StringLengthComparator());
 *  Будет сортировка по длине строки. Стандартный порядок сортировки уже не будет работать.
 *
 *  Реализовать целый класс для сортировки не всегда удобно. И когда мы хотим реализовать свою сортировку,мы
 *  можем не создавать класс , а использовать анонимные классы.
 *
 *   Collections.sort(numbers, new Comparator<Integer>() {
 *             @Override
 *             public int compare(Integer o1, Integer o2) {
 *                 if (o1 > o2){
 *                     return 1;
 *                 }else if (o1 < o2){
 *                     return -1;
 *                 }else{
 *                     return 0;
 *                 }
 *             }
 *         });
 *
 * Можно и через лямбду. Но пока не проходили.
 *
 */
public class Test {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Frog");
        animals.add("Eagle");
        animals.add("Elephant");
        //Collections.sort(animals);// статический метод сортировки в естественном порядке
        Collections.sort(animals, new StringLengthComparator());// вторым аргументом поставили наш метод сравнения
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(200);
        numbers.add(40);
        numbers.add(0);
        numbers.add(1486);
        //Collections.sort(numbers, new BackwardsIntegerComparator());
        //через анонимные классы реализуем и прямо тут предоставим нашу реализацию без создания нового класса
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return 1;
                }else if (o1 < o2){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println(numbers);

    }
}

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()){
            return 1;
        }else if (o1.length() < o2.length()){
            return -1;
        }else {
            return 0;
        }

    }
}

/*class BackwardsIntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2){
            return 1;
        }else if (o1 < o2){
            return -1;
        }else{
            return 0;
        }
    }
}*/
