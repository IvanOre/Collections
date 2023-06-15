package EqualsAndHashcode;

import java.util.*;

/**
 *Зачем нужны hashCode and Equals
 * Мы помним что ключи реализующих интерфейс map они уникальны. В МАП не может быть 2 одинаковых ключа.Певрое
 * перезаписывается новым таким же при добавлении одинаковых ключей
 * В СЕТ не может быть 2 одинаковых элемента. Они игнорируются,оставляя первый оригинал
 *
 * При создании объектов,пусть и одинаковыми значениями,тут на примере Person , выводятся без проблем 2 одинаковых
 * объекта. Не как в случае с обычными лист и сет. Джава воспринимает эти объекты как разные.
 *
 * почему так.
 * Стандартные классы в Джаве(String,Integer и тд) они все реализуют 2 метода-хешкод и еквалс.
 * Можем на них вызвать напрямую эти методы. У Объекта Персон тоже они есть,но они пришли от родителя,от Object
 * но они реализованы так,что для всех разных объектов они возвращают что это разные объекты(только если ссылки не
 * одинаковы)
 *
 * Нам нужно переопределить методы еквалс и хешкод для Персон для правильно работы. Генерируем через хоткей автоматом.
 * И теперь у нас будет вывод как с обычными объектами мап и сет.Джава увидит,что объекты одинаковые.
 * Если хотим сравнивать объекты по смыслу,то переопределяем методы еквалс и хешкод.
 * Хешкод не всегда работает правильно. Поэтому лучше использовать в паре с еквалс,что бы получить точную инфу.
 *
 * Если нам нужно миллион раз проверить объекты на равенство?
 * Через equals будет долго. Через hashcode быстро.Но не факт что точно,если только через хешкод.Редко бывает сбой.
 *
 * Хеширование это преобразование чего-то(массив) произвольной длинны,
 * в что-то(битовое представление) фиксированной длинны.
 * {object(любой длинны)}--->{int(фиксированной длинны}Сравнивать целые числа легче чем объекты произвольной длинны.
 *
 * Когда у двух объектов одинаковые хеши,но сами объекты при этом разные,это называется коллизия.
 * Она возникает по той причине,что кол-во разных хешкодов ограничено. В инт помещается 32 бита и кол-во числе там
 * ограничено.Поэтому бывает что 2 разных объекта дают 2 одинаковых числа. Рекдо, но все же.
 * И в момент когда случается коллизия мы должны вызвать метод еквалс,для дополнительного сравнения объектов.
 *
 *
 * Контракт hashcode() equals()
 * 1. У двух проверяемых объектов вызываем hashcode().
 * Если мы получили 2 разных хеша-числа,значит 2 объекта точно разные.
 * Заканчиваем работу и выдает инфу что объекты разные.
 *
 * 2. Если hashcode() вернул 2 одинаковых числа для 2  объектов.
 * Значит или объекты одинаковые ,или объекты разные,но случилась коллизия. Мы не знаем точно.
 * Если хеши одинаковые,то вызываем метод equals() более медленный для более точного сравнения
 * И уже equals() выдает точный ответ.
 *
 *
 *
 *
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1,"Ivan");
        Person person2 = new Person(1,"Ivan");

        map.put(person1,"123");
        map.put(person2,"456");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);
    // при таком выводе не происходит замещение или игнорирование. выводятся 2 объекта. потому что для джавы это
        // разные объекты. ссылаются на разные места в памяти. hashcode and equals решают проблему
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}