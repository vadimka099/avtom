import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/**
 * Реализация регулярного выражения [0-9]+ с помощью универсального
 конечного автомата (поиск чисел в тексте)
 */
public class avtomat {
    public static final int START = 0;
    public static final int LETTER = 1;
    public static void main(String[] args) {
        List<Character> letters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Set<Integer> endStates = Collections.singleton(LETTER);
        StateMachine sm = new StateMachine(START, endStates);
        // Переход START -> DIGITS при '0'..'9' на входе
        sm.add(START, letters, LETTER);
        // Переход DIGITS -> DIGITS при '0'..'9' на входе
        sm.add(LETTER,letters, LETTER);
        // Поиск всех вхождений в строке:
        String str = "abba 01.01.2017 xyzzy 02.02.2017";
        sm.findAll(str);
    }
}