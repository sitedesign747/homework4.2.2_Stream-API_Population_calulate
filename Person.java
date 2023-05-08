public class Person {
    private static String name;
    private static String family;
    private static Integer age;
    private static Sex sex;
    private static Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public static String getName() {
        return name;
    }

    public  static String getFamily() {
        return family;
    }

    public static Integer getAge() {
        return age;
    }

    public static Sex getSex() {
        return sex;
    }

    public static Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }

}
