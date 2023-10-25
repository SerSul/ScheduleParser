package com.example.scheduleparser.enums;


import com.example.scheduleparser.enums.calendar.Period;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleDocument {

    private  Institute institute;
    private  Degree degree;
    private  Period period;
    private  Course course;

    private  String url;

    public ScheduleDocument(Institute institute, Degree degree, Period period, Course course, String url) {
        this.institute = institute;
        this.degree = degree;
        this.period = period;
        this.course = course;
        this.url = url;
    }


    public Period getPeriod() {
        return period;
    }

    public String getUrl() {
        return url;
    }
}

