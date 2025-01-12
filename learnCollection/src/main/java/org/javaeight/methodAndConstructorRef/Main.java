package org.javaeight.methodAndConstructorRef;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Product> products = List.of(new Product("Bugatti Chiron", 2016),
                new Product("Ferrari LaFerrari", 2013),
                new Product("Lamborghini Aventador", 2018),
                new Product("McLaren", 2013),
                new Product("Porsche 918 Spyder", 2015));

        //Non static method directly referenced with class name
        List<Integer> serialNo = products.stream().map(Product::getSerialNo).collect(Collectors.toList());
        System.out.println(serialNo);

        //method compatible with inbuild FunctionalInterface
        Product product = new Product();
        BiFunction<String, Integer, String> save = product::Save;
        save.apply("Mustang", 1969);

        //method compatible with custom FunctionalInterface
        CustomSaveInteface saveReference = product::customSave;
        saveReference.saveProduct("Chevrolet Corvette ZR1", 2019, "341 km/h");

        //Static method referenced
        products.stream().forEach(Product::saveObject);

        //non-Static method referenced with class name, method should refere to "this"(current object) only
        List<String> savedProds = products.stream().map(Product::saveObjectAndReturn).collect(Collectors.toList());
        System.out.println(savedProds);
    }

}
