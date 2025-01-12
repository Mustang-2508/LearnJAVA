package org.javaeight.mapPrac;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        /*
        * If you comment or remove override method hashCode() and equals() of JetCompany
        * class, object p1 and p4 will be considered as different in Map, even though id and name is same,
        * as the hashcode will be calculated with the help of memory address. and in result you will get map size as 4
        * */

        HashMap<JetCompany, Integer> map = new HashMap<>();
        JetCompany p1 = new JetCompany(1, "Sukhoi");
        JetCompany p2 = new JetCompany(2, "Mig");
        JetCompany p3 = new JetCompany(3, "Dassault");
        JetCompany p4 = new JetCompany(1, "Sukhoi");

        map.put(p1, 4000);
        map.put(p2, 5000);
        map.put(p3, 6000);
        map.put(p4, 7000);

        System.out.println("Size: "+map.size());
        System.out.println("Map: "+map);
    }
}