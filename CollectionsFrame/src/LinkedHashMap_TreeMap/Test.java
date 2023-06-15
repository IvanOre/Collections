package LinkedHashMap_TreeMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Если нам важен порядок в Мапе, то используем LinkedHashMap и TreeMap
 * LinkedHashMap-сохраняет порядок добавления новых пар ключ-значение в Map
 * TreeMap-сортирует наши пары ключ-значение по ключу.
 *
 *         Map<Integer, String> hashMap = new HashMap<>();
 *         Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
 *         Map<Integer,String> treeMap = new TreeMap<>();
 *         Создали методом ссылания мапы на интерфейс который ее реализует(типа полиморфизм)
 *
 *
 *         Map<Integer, String> hashMap = new HashMap<>(); внутри не гарантируется никакого порядка
 *
 *         Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); в каком порядке пары ключ-значение были
 *         добавлены ,в таком порядке и вернуться
 *
 *         Map<Integer,String> treeMap = new TreeMap<>();гарантирует что пары ключ-значение будут отсортирован
 *         по ключу.(для ключа своего должен быть задан порядок сортировки,для цифр и строк(лексикографическая))
 *         используется естественный порядок.
 *
 *
 */

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();// внутри не гарантируется никакого порядка

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();// в каком порядке пары ключ-значение были
        //добавлены ,в таком порядке и вернуться

        Map<Integer,String> treeMap = new TreeMap<>();//гарантирует что пары ключ-значение будут отсортирован
        // по ключу.(для ключа должен быть задан порядок сортировки,кроме цифр и строк(лексикографическая))


        //testMap(hashMap);//все выводится беспорядочно случайным образом без сортировки какой либо

        //testMap(linkedHashMap);//в каком порядке добавили в таком и вывелось (88-111-13 и тд)

        testMap(treeMap);//вывелось упорядоченным списком по ключу тут цифре(7-13-44 и тд)
    }

    public  static void testMap(Map<Integer,String> map){//метод для теста работы разных Map
        map.put(88,"Ivan");
        map.put(111,"Max");
        map.put(13,"Fedor");
        map.put(54,"Max");
        map.put(7,"Alex");
        map.put(1887,"Katy");

        for (Map.Entry<Integer,String> entry : map.entrySet()){//итерируемся пов сем ключ-значения в мапе
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }


    }
}
