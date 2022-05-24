package homework;

import org.junit.jupiter.api.Test;

public class CarTrainTest {
    @Test
    public void objects () {
        Car audi = new Car();
        audi.setBrand("Audi");
        audi.setColor("black");
        audi.setType("sedan");
        audi.setMileage(30000);
        System.out.println(audi.getClass() + " " + audi.getColor() + " " + audi.getType() + " " + audi.getMileage());

        Car ford = new Car();
        ford.setBrand("Ford");
        ford.setColor("grey");
        ford.setType("crossover");
        ford.setMileage(600250);
        System.out.println(ford.getClass() + " " + ford.getColor() + " " + ford.getType() + " " + ford.getMileage());

        Car opel = new Car();
        opel.setBrand("Opel");
        opel.setColor("green");
        opel.setType("sports car");
        opel.setMileage(10008450);
        System.out.println(opel.getClass() + " " + opel.getColor() + " " + opel.getType() + " " + opel.getMileage());

        Train one = new Train();
        one.setColor("white");
        one.setType("passenger");
        one.setMileage(200081110);
        System.out.println(one.getClass() + " " + one.getColor() + " " + one.getType() + " " + one.getMileage());

        Train two = new Train();
        two.setColor("red");
        two.setType("freight ");
        two.setMileage(330081110);
        System.out.println(two.getClass() + " " + two.getColor() + " " + two.getType() + " " + two.getMileage());

    }


}
