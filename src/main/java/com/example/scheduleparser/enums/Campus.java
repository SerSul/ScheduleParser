package com.example.scheduleparser.enums;


public enum Campus {
    MP_1("МП-1", "ул. Малая Пироговская, д.1"),
    V_78("В-78", "Проспект Вернадского, д.78"),
    V_86("В-86", "Проспект Вернадского, д.86"),
    S_20("С-20", "ул. Стромынка, 20"),
    SG_22("СГ-22", "5-я ул. Соколиной горы, д.22"),
    ONLINE("СДО", "СДО"),
    BASE("База", "База");

    private final String shortName;
    private final String name;

    Campus(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }



    public String getName() {
        return name;
    }

    public static Campus getByName(String name) {
        for (Campus campus : values()) {
            if (campus.getName().equals(name)) {
                return campus;
            }
        }
        throw new IllegalArgumentException("Unknown campus name: " + name);
    }

    public static Campus getByShortName(String shortName) {
        for (Campus campus : values()) {
            if (campus.getShortName().equals(shortName)) {
                return campus;
            }
        }
        throw new IllegalArgumentException("Unknown campus short name: " + shortName);
    }
}
