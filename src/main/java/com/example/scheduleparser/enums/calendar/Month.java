package com.example.scheduleparser.enums.calendar;

public enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
    JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    private int value;

    Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Month fromString(String value) {
        String lowercaseValue = value.toLowerCase();
        return switch (lowercaseValue) {
            case "январь" -> JANUARY;
            case "февраль" -> FEBRUARY;
            case "март" -> MARCH;
            case "апрель" -> APRIL;
            case "май" -> MAY;
            case "июнь" -> JUNE;
            case "июль" -> JULY;
            case "август" -> AUGUST;
            case "сентябрь" -> SEPTEMBER;
            case "октябрь" -> OCTOBER;
            case "ноябрь" -> NOVEMBER;
            case "декабрь" -> DECEMBER;
            default -> throw new IllegalArgumentException("Invalid month: " + value);
        };
    }
}

