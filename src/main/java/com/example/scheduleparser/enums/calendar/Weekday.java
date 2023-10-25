package com.example.scheduleparser.enums.calendar;

public enum Weekday {
    MONDAY(1, "понедельник"), TUESDAY(2, "вторник"), WEDNESDAY(3, "среда"),
    THURSDAY(4, "четверг"), FRIDAY(5, "пятница"), SATURDAY(6, "суббота"), SUNDAY(7, "воскресенье");

    private int number;
    private String name;

    Weekday(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Weekday getWeekdayByNumber(int number) {
        for (Weekday weekday : Weekday.values()) {
            if (weekday.getNumber() == number) {
                return weekday;
            }
        }
        throw new IllegalArgumentException("No weekday with number " + number);
    }

    public static Weekday getWeekdayByName(String name) {
        for (Weekday weekday : Weekday.values()) {
            if (weekday.getName().equals(name)) {
                return weekday;
            }
        }
        throw new IllegalArgumentException("No weekday with name " + name);
    }

}
