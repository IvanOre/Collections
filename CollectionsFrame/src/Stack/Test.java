package Stack;

import java.util.Stack;

/**
 * Stack реализует интерфейс List и наследуется от класса Vector
 * Работает по принципу LIFO-last in,first out.
 * push() - добавляет элемент в стек
 * pop() - достает элемент из стека удаляя его(последний добавленный следуя принципу lifo)
 * peek() - показывает последний элемент из стека, не удаляя его.
 * empty()- проверяет стек на пустоту. true если стек пустой. false если не пустой
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        /*System.out.println(stack.peek());
        System.out.println(stack.pop());*/
        while (!stack.empty())
            System.out.println(stack.pop());

    }
}
