package com.example.modernjavainaction.ch08;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingCollectionsExample {

    public static void main(String[] args) {
//        creatingLists();
        /*
        Arrays.asList 로 컬렉션을 생성하게 되면 AbstractList 를 상속받는데
        AbstractList 의 add, set, remove 는 전부 UnsupportedOperationException 예외를 발생시킵니다.

        따라서 Arrays.asList 로 컬렉션을 생성하면 생성할 때의 컬렉션을 조회하는 것은 가능하지만
        조작하는 것은 불가능합니다.
         */
        /*
        List.of 의 경우 ImmutableCollections.ListN 객체를 호출하게 되는데
        이 객체는 AbstractImmutableList 를 상속받고 있습니다.
        AbstractImmutableList 는 다시 AbstractImmutableCollection 를 상속받고 있는데,
        AbstractImmutableList 는 AbstractList 와 비슷하게 add, set, remove 메소드 호출 시 전부 UnsupportedOperationException 예외를 발생시키며,
        추가로 sort 또한 UnsupportedOperationException 예외를 발생시켜 정렬도 불가능한 것을 확인할 수 있습니다.
         */

//        creatingSets();
        /*
        Set.of 는 ImmutableCollections.SetN 을 호출하게 되는데,
        동일한 요소가 있을 경우 IllegalArgumentException 예외를 발생시킵니다.
        ImmutableCollections.SetN 은 AbstractImmutableSet 을 상속 받고 있는데
        AbstractImmutableSet 은 다시 AbstractImmutableCollection 을 상속받고 있습니다.

        따라서 앞선 예제와 동일하게 add, remove, retainAll, clear 등의 메소드를 호출하게 되면 UnsupportedOperationException 예외를 발생시킵니다.
         */

        creatingMaps();
        /*
        Map.of 는 ImmutableCollections.MapN 을 호출하게 되는데,
        동일한 key 가 있을 경우에는 IllegalArgumentException 예외를 발생시킵니다.
        ImmutableCollections.MapN 은 AbstractImmutableMap 을 상속받고 있는데
        이 객체는 다시 AbstractMap 을 상속 받고 있습니다.

        따라서 clear, compute, put, merge, remove 등의 조작 메소드를 호출하게 되면 이 역시 UnsupportedOperationException 예외를 발생시킵니다.
         */
    }

    private static void creatingLists() {
        System.out.println("------ Creating Lists ------");

        System.out.println("--> Creating a list the old-fashioned way");
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");
        System.out.println(friends);

        System.out.println("--> Using Arrays.asList()");
        List<String> friends2 = Arrays.asList("Raphael", "Olivia");
        friends2.set(0, "Richard");
        System.out.println(friends2);
        try {
            friends2.add("Thibaut");
            System.out.println("We shouldn't get here...");
        } catch (UnsupportedOperationException e) {
            System.out.println("As expected, we can't add items to a list created with Arrays.asList().");
        }

        System.out.println("--> Creating a Set from a List");
        Set<String> friends3 = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
        System.out.println(friends3);

        System.out.println("--> Creating a Set from a Stream");
        Set<String> friends4 = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());
        System.out.println(friends4);

        System.out.println("--> Creating a List with List.of()");
        List<String> friends5 = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends5);
        try {
            friends5.add("Chih-Chun");
            System.out.println("We shouldn't get here...");
        } catch (UnsupportedOperationException e) {
            System.out.println("As expected, we can't add items to a list created with List.of().");
        }
        try {
            friends5.set(1, "Chih-Chun");
            System.out.println("We shouldn't get here...");
        } catch (UnsupportedOperationException e) {
            System.out.println("Neither can we replace items in such a list.");
        }
    }

    private static void creatingSets() {
        System.out.println("------ Creating Sets ------");

        System.out.println("--> Creating a Set with Set.of()");
        Set<String> friends = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);

        System.out.println("--> Trying to pass duplicate items to Set.of()");
        try {
            Set<String> friends2 = Set.of("Raphael", "Olivia", "Olivia");
            System.out.println("We shouldn't get here...");
        }
        catch (IllegalArgumentException e) {
            System.out.println("As expected, duplicate items are not allowed with Set.of().");
        }
    }

    private static void creatingMaps() {
        System.out.println("--> Creating a Map with Map.of()");
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        System.out.println(ageOfFriends);

        System.out.println("--> Creating a Map with Map.ofEntries()");
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(
                entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));
        System.out.println(ageOfFriends2);
    }

}
