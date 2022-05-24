package homework;

import org.junit.jupiter.api.Test;

public class Distance {
    @Test
    public void fuelConsumption () {
        double liter_per_1km = 0.065;
        double distance = 300;
        double liter_per_300km = liter_per_1km * distance;
        System.out.println(liter_per_300km);

    }
    @Test
    public void transportationCost () {
        double fuel = 55;
        double toll_roads = 20;
        double driver_salary = 75;
        double loading = 20;
        double unloading = 30;
        double total_amount = fuel + toll_roads + driver_salary + loading + unloading;
        System.out.println(total_amount);
    }
}
