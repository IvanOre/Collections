package ArrayListNew;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Иерархия
 *                                     Iterable
 *                                        |
 *                                    Collection
 *                            ____________|___________________________
 *                            |                                     |
 *                           List       | Queue                     Set
 *                        ArrayList   |   |    |                  |       |
 *                        LinkedList->|    |  ProrityQueue         |      HashSet
 *                        Vector         |                      |           |
 *                          |         Deque                     |         LinkedHashSet
 *                        Stack          |                  SortedSet
 *                                    ArrayDeque                |
 *                                                             TreeSet
 *
 * Interfaces--->(Iterable,Collection,List,Queue,Set,Deque,SortedSet)
 *
 * Class--->(ArrayList,LinkedList,Vector,Stack,PriorityQueue,ArrayDeque,HashSet,LinkedHashSet,TreeSet)
 *
 *
 * ArrayList модель массива который расширяется при добавлении в него элементов
 * пробуя поместить в массив больше элементов чем там указано,мы получаем ошибку.
 *  int[] x = new int[3];
 *         for (int i = 0; i < 4; i++){
 *             x [i] = 1;
 *         }
 *
 * Все классы параметризованы <> , ArrayList<Integer> или другой какой нам нужен
 *
 * Когда кончается место в массиве,создается новый  внутренний массив и все объекты копируются туда.
 * Причем новый массив в 2 раза больше чем старый.Так достигается эффект динамичности,наш ArrayList сам расширяется
 * Но мы никуда не уходим от ограничений массива. Если мы удаляем элемент из arrayLista, значит мы удаляем
 * элемент из внутреннего массива
 *
 * arrayList.remove(); не эффективное удаление
 * Есть массив из 10 элементов. Удаляем например 5 элемент. Остается пустое пространство. И все элементы после 5
 * удаленной сдвигаются влево,что бы не было пустого места в массиве и размер массива уменьшается на 1.
 * Это удаление занимает много времени.
 * Если мы знаем что будем удалять элементы из середины листа,то лучше отказаться от использования аррайЛиста и
 * использовать LinkedList
 *
 * Когда мы ссылаем объект класса на тот интерфейс который его реализует мы можем сделать следующее
 * Допустим нас устраивает ArrayList в этой части программы
 *    List<Integer> list = new ArrayList<>();
 *         // .add(); добавить элементы в а него
 *        for (int i = 0; i < 10; i++){
 *            list.add(i);
 *        }
 *
 *   Далее нам требуется часто удалять элементы из листа и мы можем просто наш list сослать на new LinkedList<>
 *       но надо не забыть перенести в него все наши старые элементы из ArrayList
 *
 *  list = new LinkedList<>();
 *  И теперь у нас линкедлист из которого удобнее удалять элементы. Это не прям уж полезно,но показывает удобность
 *  конвенции,когда мы не думаем о реализации листа,мы можем его поменять на ходу.Часто увидим в практике
 *
 *
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();//размер по умолчанию 10. можем сами указать если знаем сколько будет
        // .add(); добавить элементы в а него
       for (int i = 0; i < 10; i++){
           list.add(i);
       }
        /*System.out.println(arrayList);
        // .get() получить элемент из массива
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(99));

        // .size() получим размер листа
        System.out.println(arrayList.size());*/

        // .remove(55) удаляем объект под индексом 55 например
        list.remove(5);
        System.out.println(list);




        /*// пройдемся по всем элементам листа
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        // через for each
        for (Integer x : arrayList)
            System.out.println(x);*/

    }
}
