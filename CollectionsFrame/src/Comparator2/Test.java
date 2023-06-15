package Comparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(2,"Ivan"));
        people.add(new Person(3,"Max"));
        people.add(new Person(4,"Boris"));
        people.add(new Person(1,"Anatoliy"));

        //Collections.sort(people);// ошибка. тк мы не задали в нашем Person естественного порядка
        // в обычных типах типа инт и стринг есть естественный порядок по умолчанию

        Collections.sort(people, new Comparator<Person>() {// можем через анонимный класс/ сортируем по id
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()){
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;

                }else {
                    return 0;
                }
            }
        });
        System.out.println(people);

    }
}


class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}