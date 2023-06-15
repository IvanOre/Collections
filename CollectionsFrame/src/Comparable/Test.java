package Comparable;

import java.util.*;

/**
 *
 *Дадим естественный порядок объектам нашего класса собственного
 * Что бы дать понять джаве что объекты нашего класса сортируемы,у них есть порядок,мы должны реализовать в нашем
 * классе интерфейс Comparable(способный быть сравненным) ОН реализуем метод compareTo() и в нем описываем
 * логику сравнения объектов
 *
 */
public class Test {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();// гарантирует отсортированность в себе. как только задали условие

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);


        System.out.println(peopleList);
        System.out.println(peopleSet);

    }

    private static void addElements(Collection collection){
        collection.add(new Person(4,"Anatoliy"));
        collection.add(new Person(2,"Max"));
        collection.add(new Person(1,"Ivan"));
        collection.add(new Person(3,"Boris"));



    }
}

class Person implements Comparable<Person>{
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {// сравниваем по name по длинне например
        if (this.name.length() > o.getName().length()){// это(сравниваемое name) больше чем то name с каким сравниваем то возвращаем 1 и тд
            return 1;
        } else if (this.name.length() < o.getName().length()) {
            return -1;

        }else {
            return 0;
        }
    }
}