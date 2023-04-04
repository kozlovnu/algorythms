package Seminar;
import java.sql.Date;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Seminar1 {
    // написать алгоритм считающий сумму всех чисел от 1 до N

    public static void sumNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            sum += i;
        }
        System.out.println(sum);
    }

    // написать алгоритм поиска простых чисел
    public static void findPrimeNumbers(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                primeNumbers.add(i);
            }
        }
        System.out.println(primeNumbers);
    }

    // Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать
    // количество) для количества кубиков K с количеством граней N

    public static void findCombinations() {
        List<Integer> combunations = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        System.out.printf("%d %d %d %d\n", i, j, k, l);
                    }
                }
            }
        }
    }

    // Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
    // Считаем, что 1 и 2 значения последовательности равны 1.
    // Искать будем по формуле On=On-1+On-2 что предполагает использовать
    // рекурсивного алгоритма.

    public static int fibonacci(int pos) {
        if (pos == 1 || pos == 2) {
            return 1;
        } 
        else {
            return fibonacci(pos - 1) + fibonacci(pos - 2);
        }
    }

    //  фибоначчи через цикл
    public static int fib(int pos){
        int num1 = 0;
        int num2 = 1;
        int result = 1;
        for (int i = 1; i < pos; i++){
            int k = num2;
            num2 += num1;
            num1 = k;
            
        }
        return num2;
    }

    public static void main(String[] args) {
        // sumNumbers(5);
        // findPrimeNumbers(120);
        // findCombinations();
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(45)); 
        long finish = System.currentTimeMillis();
        
        long start1 = System.currentTimeMillis();
        System.out.println(fib(100));
        long finish2 = System.currentTimeMillis();

        System.out.println(finish-start);
        System.out.println(finish2-start1);

    }
}