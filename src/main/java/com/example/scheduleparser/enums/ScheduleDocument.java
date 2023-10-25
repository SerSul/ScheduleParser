package com.example.scheduleparser.enums;


import com.example.scheduleparser.enums.calendar.Period;

public class ScheduleDocument {
    private final Institute institute;
    private final Degree degree;
    private final Period period;
    private final String url;

    public ScheduleDocument(Institute institute, ScheduleType scheduleType, Degree degree, Period period, String url) {
        this.institute = institute;
        this.degree = degree;
        this.period = period;
        this.url = url;
    }

    public Institute getInstitute() {
        return institute;
    }



    public Degree getDegree() {
        return degree;
    }

    public Period getPeriod() {
        return period;
    }

    public String getUrl() {
        return url;
    }
}

