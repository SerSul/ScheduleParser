package com.example.scheduleparser.enums;

public enum Course {
    COURSE_1(1, "1 курс"),
    COURSE_2(2, "2 курс"),
    COURSE_3(3, "3 курс"),
    COURSE_4(4, "4 курс"),
    COURSE_5(5, "5 курс");

    private final int value;
    private final String name;

    Course(int value, String name) {
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

