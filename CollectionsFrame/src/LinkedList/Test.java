package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList связный список.
 * Имеет все методы которые имеет ArrayList . add,get,remove,size .....
 *
 *   public static void main(String[] args) {
 *         List<Integer> linkedList = new LinkedList<>();
 *         List<Integer> arrayList = new ArrayList<>();
 *
 *         measureTime(linkedList);// 201ms
 *         measureTime(arrayList);//93ms
 *
 *     }
 * //метод измеряющий время выполнения
 *     private static void measureTime(List<Integer> list){
 *         long start = System.currentTimeMillis();
 *
 *         for (int i = 0; i < 1000000; i++){
 *             list.add(i);
 *         }
 *
 *         long end  = System.currentTimeMillis();
 *         System.out.println(end - start);
 *
 *     }
 *
 *     LinkedList время выполнения больше в 1 раза оказалось по добавлению 100000 числе в него.
 *     Поэтому если нужно просто добавлять очень много объектов в лист,лучше использовать ArrayList
 *
 *
 *     при Считывании
 *     for (int i = 0; i < 100000; i++){// считываем все наши элементы из листов
 *             list.get(i);
 *         }
 *
 *  у linkedList = 3281
 *  у arrayList = 4.
 *
 *  Тоже лучше использовать ArrayList если нужно считать много элементов
 *  у linkedList нужно пройтись по всем узлам с 1 что бы найти элемент под нужным индексом.
 *
 *
 *  Метод .add() записывает в конец листа. []-[0]-[0][1]-[0][1][2]-[0][1][2][3]и тд
 *
 *  ArrayList в нем лучше.
 *
 *
 *
 *
 *
 *  А теперь попробуем метод записи в начало листа list.add(0,i);  где 0 это индекс места куда начинаем писать
 *  []-[0]-[1][0]-[2][1][0]-[3][2][1][0]  и тд каждый раз новый элемент в индекс 0 помещаем а предыдущие сдвигаем
 *  вправо
 *  Тут уже другие результаты.
 *  У linkedList заняло 8 мс, а у arrayList заняло 776 мс. В таком методе linkedList намного быстрее
 *
 *
 *
 *  Почему так происходит???
 *  Эти 2 листа имеют разную реализацию.
 *  ArrayList хранит инфу в массиве. LinkedList использует цепочку узлов. У каждого объекта есть значение и ссылка
 *  на следующий объект head->[1]->[2]->[3]. Когда хотим добавить новый элемент в линкедЛист в позицию 0, мы просто
 *  головной (head) элемент ссылаем на новый добавленный,а новый добавленный на 1 и весь лист сместился вправо.
 *
 *  Резюме
 *  Если много записей в конец и много считываний из листа,то юзаем ArrayList
 *  Если много удалений или добавлений в начало листа,то юзаем LinkedList
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);// на добавление 201ms   и 3281 на считывание
        measureTime(arrayList);// на добавление 93ms     и 4 на считывание

    }
//метод измеряющий время выполнения
    private static void measureTime(List<Integer> list){

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++){// добавляем 100000 числе в наши листы
            list.add(0,i);
        }

        long end  = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
