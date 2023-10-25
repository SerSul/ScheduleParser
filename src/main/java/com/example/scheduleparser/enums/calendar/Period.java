package com.example.scheduleparser.enums.calendar;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;
@Data
public class Period {
        int yearStart;
        int yearEnd;
        int semester;

        public Period(int yearStart, int yearEnd, int semester) {
            this.yearStart = yearStart;
            this.yearEnd = yearEnd;
            this.semester = semester;
        }

    public static Period getPeriod(LocalDate date) {
        if (date.getMonthValue() >= 7) {
            return new Period(date.getYear(), date.getYear() + 1, 1);
        } else {
            return new Period(date.getYear() - 1, date.getYear(), 2);
        }
    }

    public static ZonedDateTime nowDate() {
        return ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }

    public static LocalDate getSemesterStart(Period period) {
        if (period.getSemester() == 1) {
            LocalDate startDate = LocalDate.of(period.getYearStart(), 9, 1);
            if (startDate.getDayOfWeek().getValue() == 6) {
                startDate = startDate.plusDays(1);
            }
            return startDate;
        }

        LocalDate startDate = LocalDate.of(period.getYearEnd(), 2, 1);

        startDate = startDate.plusDays(8);

        if (startDate.getDayOfWeek().getValue() == 6) {
            startDate = startDate.plusDays(1);
        }

        return startDate;
    }

    public static void main(String[] args) {
        Period period = new Period(2023, 2024, 1);

    }
}
