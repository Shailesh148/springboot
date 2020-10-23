package com.practice.learning.service;


import com.practice.learning.model.City;
import com.practice.learning.model.FunctionalInterfaceTestYo;
import com.practice.learning.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

@RunWith(SpringRunner.class)
public class FunctionalInterfaceTest {

    @Test
    public void testfunctionalInterface() {
        FunctionalInterfaceTestYo<String> functionalInterface1 = s -> s.length() > 1;

        System.out.println("String has length more than 2: " + functionalInterface1.test("Hello"));

        FunctionalInterfaceTestYo<String> functionalInterface2 = s -> s.length() <= 2;

        //combined functional interface

        FunctionalInterfaceTestYo<String> functionalInterface3 = functionalInterface1.and(functionalInterface2);


        System.out.println("Testing function 3: " + functionalInterface3.test("He"));


        //printing out the predicate using static method compares given string with a fixed string to build that predicate below

        FunctionalInterfaceTestYo<String> functionalInterface4 = FunctionalInterfaceTestYo.isEqualsTo("Yes");


        System.out.println("Check equals to 4: " + functionalInterface4.test("Yes"));

        System.out.println("Check equals to 4: " + functionalInterface4.test("No"));

    }

    @Test
    public void testUsefulListFunctions() {


        Person p1 = new Person("Shailesh", 27);
        Person p2 = new Person("Utsav", 25);
        Person p3 = new Person("Ayush", 35);
        Person p4 = new Person("Adhip", 26);

        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));


        personsList.removeIf(p -> p.getAge() > 30);

        personsList.replaceAll(p -> new Person(p.getName().toUpperCase(), p.getAge()));

        personsList.sort(Comparator.comparing(Person::getName).thenComparing((Person::getAge)));

        personsList.forEach(System.out::println);


    }


    @Test
    public void testUsefulMapFunctions() {


        Person p1 = new Person("Shailesh", 27);
        Person p2 = new Person("Utsav", 25);
        Person p3 = new Person("Ayush", 35);
        Person p4 = new Person("Adhip", 26);

        City c1 = new City("Hyderabad");
        City c2 = new City("Pokhara");
        City c3 = new City("Kathmandu");

        Map<City, List<Person>> mapList = new HashMap<>();

        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));

        //way 1
        mapList.putIfAbsent(c3, new ArrayList<>());

        mapList.put(c3, personsList);

        //way 2

        mapList.computeIfAbsent(c3, (k) -> new ArrayList<>()).add(p1);


        mapList.forEach((k, v) -> System.out.println("Each map Key: " + k.getName()));

    }

    @Test
    public void testMapFilterReduceFunctions() {
        List<Integer> l1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> l2 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> l3 = Arrays.asList(5, 6, 7, 8, 9);

        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;

//        int reduction = reduce(l1, 0, op);

        int reduction1 = reduce(l2, 0, op);
        int reduction2 = reduce(l3, 0, op);
        int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);

        System.out.println("Reduction: " + reduction);
    }


    public static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> op) {
        int result = valueIfEmpty;
        for (int value : values) {
            result = op.apply(result, value);
        }
        return result;
    }


    @Test
    public void testStreamsOperations() {
        Person p1 = new Person("Shailesh", 27);
        Person p2 = new Person("Utsav", 25);
        Person p3 = new Person("Ayush", 35);
        Person p4 = new Person("Adhip", 26);

        List<Person> personsList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));


        //map call changes the type of stream.
        //filter call doesnt change the type of stream and returns a new object every time

        personsList.stream()
                .map(p -> p.getAge())
                .filter(age -> age < 29)
                .forEach(System.out::println);


        personsList.stream()
                .filter(p -> p.getAge() < 29)
                .forEach(System.out::println);

        //a call that returns a stream is an intermediate call, and which doesnt or is void is a terminal call
        personsList.stream()
                .map(p -> p.getAge())
                .peek(System.out::println)        //helps bypass the stream from map to filter so that filter contains stream object where it could work on with. peek is always an intermediate operation.
                .filter(age -> age < 29)
                .forEach(System.out::println);


        System.out.println("Using skip and limit");
        personsList.stream()
                .skip(1)
                .limit(1)
                .map(p -> p.getAge())
                .peek(System.out::println)        //helps bypass the stream from map to filter so that filter contains stream object where it could work on with. peek is always an intermediate operation.
                .filter(age -> age < 29)
                .forEach(System.out::println);


        //Now streams with reduction
        //anyMatch, allMatch, noneMatch => return boolean

        //find Reductions
        //findFirst, findAny

        Optional<Integer> opt = personsList.stream()
                .map(p -> p.getAge())
                .filter(age -> age > 25)
                .findFirst();

        System.out.println("Reduction: ");
    }


}
