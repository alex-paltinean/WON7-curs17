package org.fasttrackit;

import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        MethodReferences methodReferences = new MethodReferences();
        methodReferences.printTransform(methodReferences::anotherSuffix);
        methodReferences.printTransform(String::toLowerCase);
        methodReferences.printTransform(s -> s.toLowerCase());
    }

    void printTransform(Function<String, String> logic) {
        System.out.println(logic.apply("hello"));
    }

    public String anotherSuffix(String a) {
        return a + "another";
    }
}
