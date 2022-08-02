package org.fasttrackit;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamExercise {
    public static void main(String[] args) {
        List<Citizen> citizens = List.of(
                new Citizen("Ana", 15, "student", false),
                new Citizen("Raul", 34, "artist", true),
                new Citizen("Bogdan", 23, "designer", true),
                new Citizen("Raluca", 45, "artist", false)
        );

        citizens.stream()
                .filter(citizen -> citizen.profession().equals("artist"))
                .filter(citizen -> !citizen.married())
                .filter(citizen -> citizen.age() < 50)
                .map(citizen -> "Our pick is: " + citizen.name())
                .findFirst()
                .ifPresent(System.out::println);

        // sorting
        List<String> sortedListOfNamesAsc = citizens.stream()
                .map(Citizen::name)
                .sorted()
                .toList();

        List<String> sortedListOfNamesDesc = citizens.stream()
                .map(Citizen::name)
                .sorted(Comparator.reverseOrder())
                .toList();

        // print all professions ordered by citizen name desc
        citizens.stream()
                .sorted(Comparator.comparing(Citizen::name).reversed())
                .map(Citizen::profession)
                .forEach(System.out::println);

        List<Citizen> orderedCitizensByProfessionThanName = citizens.stream()
                .sorted(Comparator.comparing(Citizen::profession).thenComparing(Citizen::name))
                .toList();

        citizens.stream()
                .sorted(Comparator.comparingInt(c -> c.name().length()))
                .forEach(System.out::println);

        List<Integer> numbers = List.of(4, 6, 2, 7, 9, 1, 2, 4);
        // get all even
        List<Integer> evenNumbers = numbers.stream()
                .filter(i -> i % 2 == 0)
                .toList();

        // get first 3 numbers
        List<Integer> integers = numbers.stream()
                .limit(3)
                .toList();

        // count all numbers higher than 4
        long count = numbers.stream()
                .filter(i -> i > 4)
                .count();

        // find average
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }
}

record Citizen(String name, int age, String profession, boolean married) {

}
