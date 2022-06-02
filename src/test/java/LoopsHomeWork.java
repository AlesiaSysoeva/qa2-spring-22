import lesson2.Student;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LoopsHomeWork {
    @Test
    public void loopsHomeWork () {
        List<Integer> arrayNumbers = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            if (i / 2 == 4) {
                arrayNumbers.add(i);
                System.out.println(i);
            }
        }
        for (int i = 0; i <= 20; i++) {
        if (i % 2 == 0) {
            arrayNumbers.add(i);
            System.out.println(i);
        }
        }
    }

    @Test
    public void students() {
        Student katya = new Student();
        katya.setFirstName("Katya");
        katya.setLastName("Black");
        katya.setCourse("QA1");

        Student dima = new Student();
        dima.setFirstName("Dima");
        dima.setLastName("Green");
        dima.setCourse("QA2");

        Student ivan = new Student();
        ivan.setFirstName("Ivan");
        ivan.setLastName("White");
        ivan.setCourse("QA1");

        Student denis = new Student();
        denis.setFirstName("Denis");
        denis.setLastName("Yellow");
        denis.setCourse("QA1");

        Student dasha = new Student();
        dasha.setFirstName("Dasha");
        dasha.setLastName("Grey");
        dasha.setCourse("QA2");

        List<Student> students = new ArrayList<>();
        students.add(katya);
        students.add(dima);
        students.add(ivan);
        students.add(denis);
        students.add(dasha);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + " " + students.get(i).getFirstName() + " " + students.get(i).getLastName());
        }

        for (Student student : students) {
            if (student.getCourse().equals("QA1"))
            System.out.println(student.getFirstName());
        }

    }

}
