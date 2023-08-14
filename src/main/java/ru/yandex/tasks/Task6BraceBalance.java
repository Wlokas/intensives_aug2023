package ru.yandex.tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.*;

public class Task6BraceBalance {

    public static void main(String[] args) {
        selfCheck();
    }

    public static boolean checkBalance(String sequence) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> types = new HashMap<>();
        types.put(')', '(');
        types.put(']', '[');
        types.put('}', '{');
        for (int i = 0; i < sequence.length(); i++) {
            char symbol = sequence.charAt(i);
            if (symbol == '[' || symbol == '(' || symbol == '{') {
                stack.push(symbol);
            } else {
                if (stack.peek() == types.get(symbol)) {
                    stack.poll();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
