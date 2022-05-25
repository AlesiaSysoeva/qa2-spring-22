import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Loops {
    @Test
    public void loopsLesson () {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Olaf");
        studentNames.add("Dmitry");
        studentNames.add("Oleg");
        studentNames.add("Anna");
        studentNames.add("Olga");
        System.out.println(studentNames.get(1));
        System.out.println(studentNames.size());
        System.out.println(studentNames.isEmpty());

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i));
        }
        for (String name : studentNames) {
            System.out.println(name);
        }

        for (String name : studentNames) {
            if (name.startsWith("O")) {
                System.out.println(name);
            }
            else {
                System.out.println(name + " This name doesn't start with O");
            }
        }
    }
}
