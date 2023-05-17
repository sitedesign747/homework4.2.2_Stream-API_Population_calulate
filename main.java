import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        long count1;
        long count2 = 0;
        long countArmy = 0;
        long countWorkers = 0;
        String falily2;
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

            List<String> d = persons.stream()
                    .filter(x -> Person.getAge() >= 18 && Person.getAge() <= 27)
                    .filter(y -> Person.getSex().equals(Sex.MAN))
                    .map(Person::getFamily)
                    .collect(Collectors.toList());
            if (d.size() != 0 && i > 9000000) {
                System.out.println(d);
            }
            if (d.size() != 0) {
                countArmy++;
            }

            List<String> d2 = persons.stream()
                    .filter(x -> Person.getEducation().equals(Education.HIGHER))
                    .filter(x -> Person.getAge() >= 18)
                    .filter(x -> Person.getSex().equals(Sex.MAN) ? Person.getAge() <= 65 : Person.getAge() <= 60)
                    .sorted(Comparator.comparing(Person::getFamily))
                    .map(Person::getFamily)
                    .collect(Collectors.toList());
            if (d2.size() != 0 && i > 9000000) {
                System.out.println(d2);
            }
            if (d2.size() != 0) {
                countWorkers++;
            }
        }
        System.out.println("Найдено несовершеннолетних - " + count2);
        System.out.println("Найдено призывников - " + countArmy);
        System.out.println("Найдено рабочих мужчин и женщин - " + countWorkers);

    }
}
