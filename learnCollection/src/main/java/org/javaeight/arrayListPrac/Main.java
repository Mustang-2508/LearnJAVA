package org.javaeight.arrayListPrac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = Arrays.asList(new Car("Supra", "Red", 30.2),
                new Car("Mustang", "Black", 40.2),
                new Car("GTR", "red", 20.5),
                new Car("Chiron", "Black", 20.5)
                );

        Comparator<Car> carComparator = Comparator.comparing(Car::getMilage).reversed().thenComparing(Car::getModel);

        carList.sort(carComparator);

        System.out.println(carList);


    }
}
