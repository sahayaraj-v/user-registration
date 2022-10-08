package com.example.userregistration;

import java.util.ArrayList;
import java.util.List;

public class Average {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        Double average = list.stream().mapToInt(i->i).average().getAsDouble();
        System.out.println(average);
    }
}
