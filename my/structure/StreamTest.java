package structure;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        testPure();
        testStream();
        testStreamParallel();
    }

    private static void testPure() {
        System.out.println("testPure start");
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 1; i <= 100000000; i++) {
            sum = lambda(sum, i);
        }
        System.out.println("testPure sum = " + sum);
        System.out.println("testPure end => " + (System.currentTimeMillis() - start));
    }

    private static void testStreamParallel() {
        System.out.println("testStreamParallel start");
        long start = System.currentTimeMillis();
        int sum =Stream.iterate(1, i -> i + 1)
                .parallel()
                .limit(100000000)
                .reduce((a, b) -> lambda(a, b)).get();
        System.out.println("testStreamParallel sum = " + sum);
        System.out.println("testStreamParallel end => " + (System.currentTimeMillis() - start));
    }

    private static void testStream() {
        System.out.println("testStream start");
        long start = System.currentTimeMillis();
        int sum = Stream.iterate(1, i -> i + 1)
                .limit(100000000)
                .reduce((a, b) -> lambda(a, b)).get();
        System.out.println("testStream sum = " + sum);
        System.out.println("testStream end => " + (System.currentTimeMillis() - start));
    }

    private static Integer lambda(Integer a, Integer b) {
        Integer ret = 0;
        for (int i = 0; i < 100; i++) {
            ret += a % b + b;
        }
        return ret;
    }

}
