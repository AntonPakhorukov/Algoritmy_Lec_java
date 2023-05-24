import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture_01 {

    public static void main(String[] args) {
        // List<Integer> availableDivider = findAvailableDivider(12);
        // for (int i = 0; i < availableDivider.size(); i++) {
        //     System.out.print(availableDivider.get(i) + " ");
        // }
        // System.out.println();
        // List<Integer> availableSimple = findSimpleNumbers(12);
        // for (Integer integer : availableSimple) {
        //     System.out.println(integer);
        // }
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());

    }

    public static List<Integer> findAvailableDivider(int number) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
            counter++;
        }
        System.out.println("First " + counter);
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
                counter++;
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Second " + counter);
        return result;
    }

    public static int fib (int position, AtomicInteger counter) { // AtomicInteger может меняться
        counter.incrementAndGet(); // при запуске всегда делает инкремент
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}
