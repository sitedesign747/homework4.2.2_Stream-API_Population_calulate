import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        long count1 = 0;
        long count2 = 0;
        long countArmy = 0;
        long countWorkers = 0;
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
             count1 = IntStream.of(Person.getAge())
                    .filter(x -> x < 18)
                    .count();
            count2 = count2 + count1;

        Stream<Integer> namesArmy = Stream.of(Person.getAge());
        List<String> d =  namesArmy
                .filter(x -> x >= 18 && x <= 27)
                .map(y -> String.valueOf(Person.getSex()))
                .filter(y -> y == "MAN")
                .map(n ->  String.valueOf(Person.getFamily()))
                .collect(Collectors.toList());
        if (d.size()!=0) {System.out.println(d);}
        if (d.size()!=0) { countArmy++; }

        Stream<Integer> familiesManWorkers = Stream.of(Person.getAge());
        List<String> d2 =  familiesManWorkers
                .filter((Integer x) ->  x >= 18 && x <= 65)
                .map(y -> String.valueOf(Person.getEducation()))
                .filter(y -> y == "HIGHER")
                .map(y -> String.valueOf(Person.getSex()))
                .filter(y -> y == "MAN")
                .map(n ->  String.valueOf(Person.getFamily()))
                .sorted(Comparator.comparing(y -> Person.getFamily()))
                 .collect(Collectors.toList());
            if (d2.size()!=0) {System.out.println(d2);}
            if (d2.size()!=0) { countWorkers++; }

            Stream<Integer> familiesWomanWorkers = Stream.of(Person.getAge());
            List<String> d3 =  familiesWomanWorkers
                    .filter((Integer x) ->  x >= 18 && x <= 60)
                    .map(y -> String.valueOf(Person.getEducation()))
                    .filter(y -> y == "HIGHER")
                    .map(y -> String.valueOf(Person.getSex()))
                    .filter(y -> y == "WOMAN")
                    .map(n ->  String.valueOf(Person.getFamily()))
                    .sorted(Comparator.comparing(y -> Person.getFamily()))
                    .collect(Collectors.toList());
            if (d3.size()!=0) {System.out.println(d3);}
            if (d3.size()!=0) { countWorkers++; }
    }

        System.out.println("Найдено несовершеннолетних - " + count2);
        System.out.println("Найдено призывников - " + countArmy);
        System.out.println("Найдено рабочих мужчин и женщин - " + countWorkers);

        }
}
