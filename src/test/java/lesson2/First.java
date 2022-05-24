package lesson2;

import org.junit.jupiter.api.Test;

public class First {
    @Test
    public void usingObjects() {
        Student misha = new Student();
        misha.setFirstName("Misha");
        misha.setLastName("Mi");
        misha.setAge(25);
        misha.setPersonalCode("2222-1111");
        System.out.println(misha.getFirstName() + " " + misha.getLastName());
    }
}
