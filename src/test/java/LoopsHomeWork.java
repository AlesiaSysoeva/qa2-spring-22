import org.junit.jupiter.api.Test;

import java.util.*;

public class LoopsHomeWork {
    @Test
    public void loopsHomeWork () {
        List<Integer> array1 = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            if (i / 2 == 4) {
                System.out.print(i);
                System.out.print("|");
                array1.add(i);
            }


        }
        for (int i = 0; i <= 20; i++) {
        if (i % 2 == 0) {
            System.out.println(i);
            array1.add(i);
        }
        }



    }

}
