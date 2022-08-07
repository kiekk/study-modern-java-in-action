package com.example.modernjavainaction.ch05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.
        List<Transaction> quiz1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        // [{Trader:Brian in Cambridge, year: 2011, value: 300}, {Trader:Raoul in Cambridge, year: 2011, value: 400}]
        System.out.println(quiz1);
        System.out.println("---");

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> quiz2 = Stream.of(raoul, mario, alan, brian).map(Trader::getCity).distinct().collect(Collectors.toList());
        // [Cambridge, Milan]
        System.out.println(quiz2);
        System.out.println("---");

        List<String> quiz21 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        // [Cambridge, Milan]
        System.out.println(quiz21);
        System.out.println("---");

        Set<String> quiz22 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet());
        // [Cambridge, Milan]
        System.out.println(quiz22);
        System.out.println("---");


    }
}
