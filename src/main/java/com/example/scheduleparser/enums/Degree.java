package com.example.scheduleparser.enums;

public enum Degree {
    BACHELOR(1, "БАКАЛАВРИАТ/СПЕЦИАЛИТЕТ"),
    MASTER(2, "МАГИСТРАТУРА"),
    PHD(3, "АСПИРАНТУРА"),
    COLLEGE(4, "КОЛЛЕДЖ");

    private int value;
    private String name;

    Degree(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
