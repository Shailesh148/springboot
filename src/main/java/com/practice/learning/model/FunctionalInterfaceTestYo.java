package com.practice.learning.model;


@java.lang.FunctionalInterface
public interface FunctionalInterfaceTestYo<T> {

    public boolean test(T t);


    public default FunctionalInterfaceTestYo<T> and(FunctionalInterfaceTestYo<T> second) {
        return (y -> test(y) && second.test(y));
    }

    public static <U> FunctionalInterfaceTestYo<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }

}
