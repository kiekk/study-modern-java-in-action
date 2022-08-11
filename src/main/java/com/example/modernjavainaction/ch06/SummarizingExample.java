package com.example.modernjavainaction.ch06;

import java.util.IntSummaryStatistics;

import static java.util.stream.Collectors.*;

public class SummarizingExample {

    public static void main(String[] args) {
        // Total calories in menu: 4300
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        // Average calories in menu: 477.77777777777777
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        // Menu statistics: IntSummaryStatistics{count=9, sum=4300, min=120, average=477.777778, max=800}
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        // Short menu: porkbeefchickenfrench friesriceseason fruitpizzaprawnssalmon
        System.out.println("Short menu: " + getShortMenu());
        // Short menu comma separated: pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    // summingInt 는 mapToInt 와 sum 으로 대체 가능
//    private static int calculateTotalCalories() { return Dish.menu.stream().mapToInt(Dish::getCalories).sum(); }

    private static Double calculateAverageCalories() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    // summarizingInt / summarizingLong / summarizingDouble 는 합계, 평균, 최대, 최소, 개수 등의 통계 정보가 각각
    // IntSummaryStatistics / LongSummaryStatistics / DoubleSummaryStatistics 객체에 담겨 반환됨.
    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    // delimiter 가 없을 경우 문자열이 바로 연결되어 출력
    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
