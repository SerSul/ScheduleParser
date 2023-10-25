package com.example.scheduleparser.enums;

public enum Institute {
    IIT("ИИТ", "Институт информационных технологий"),
    III("ИИИ", "Институт искусственного интеллекта"),
    IKB("ИКБ", "Институт кибербезопасности и цифровых технологий"),
    IPTIP("ИПТИП", "Институт перспективных технологий и индустриального программирования"),
    IRI("ИРИ", "Институт радиоэлектроники и информатики"),
    ITU("ИТУ", "Институт технологий управления"),
    ITHT("ИТХТ", "Институт тонких химических технологий им. М.В. Ломоносова"),
    COLLEGE("КПК", "Колледж программирования и кибербезопасности");

    private String shortName;
    private String name;

    Institute(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Institute getByName(String name) {
        for (Institute institute : values()) {
            if (institute.getName().equals(name)) {
                return institute;
            }
        }
        throw new IllegalArgumentException("Unknown institute name: " + name);
    }

    public static Institute getByShortName(String shortName) {
        for (Institute institute : values()) {
            if (institute.getShortName().equals(shortName)) {
                return institute;
            }
        }
        throw new IllegalArgumentException("Unknown institute short name: " + shortName);
    }
}
