package dz.shared.domain.time;

import lombok.Getter;
import lombok.Setter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class CustomDate {
    //
    private static final String DEFAULT_STRING_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_STRING_DATE_FORMAT = "yyyy-MM-dd";

    private ZoneId zoneId;
    private LocalDateTime time;

    public CustomDate() {
        this.zoneId = ZoneId.systemDefault();
        this.time = LocalDateTime.now();
    }

    public CustomDate(ZoneId zoneId) {
        this.zoneId = zoneId;
        this.time = LocalDateTime.now();
    }

    public static CustomDate now() {
        return new CustomDate();
    }

    public static CustomDate now(ZoneId zoneId) {
        return new CustomDate(zoneId);
    }

    public static CustomDate custom(LocalDateTime time) {
        CustomDate customDate = new CustomDate();
        customDate.setTime(time);
        return customDate;
    }

    public static CustomDate custom(LocalDateTime time, ZoneId zoneId) {
        CustomDate customDate = new CustomDate(zoneId);
        customDate.setTime(time);
        return customDate;
    }

    public static CustomDate customAtStartTime(LocalDate time) {
        //
        CustomDate customDate = new CustomDate();
        customDate.setTime(time.atTime(LocalTime.MIN));
        return customDate;
    }

    public static CustomDate customAtEndTime(LocalDate time, ZoneId zoneId) {
        //
        CustomDate customDate = new CustomDate(zoneId);
        customDate.setTime(time.atTime(LocalTime.MAX));
        return customDate;
    }

    public static CustomDate custom(long time) {
        //
        CustomDate customDate = new CustomDate();
        Instant instant = Instant.ofEpochMilli(time);
        customDate.setTime(instant.atZone(customDate.zoneId).toLocalDateTime());
        return customDate;
    }

    public static CustomDate custom(long time, ZoneId zoneId) {
        //
        CustomDate customDate = new CustomDate(zoneId);
        Instant instant = Instant.ofEpochMilli(time);
        customDate.setTime(instant.atZone(customDate.zoneId).toLocalDateTime());
        return customDate;
    }

    public static CustomDate custom(Date date) {
        //
        CustomDate customDate = new CustomDate();
        customDate.setTime(date.toInstant().atZone(customDate.getZoneId()).toLocalDateTime());
        return customDate;
    }

    public static CustomDate custom(Date date, ZoneId zoneId) {
        //
        CustomDate customDate = new CustomDate(zoneId);
        customDate.setTime(date.toInstant().atZone(zoneId).toLocalDateTime());
        return customDate;
    }

    public static CustomDate custom(String time) {
        //
        CustomDate customDate = new CustomDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_STRING_DATE_FORMAT);
        customDate.setTime(LocalDateTime.parse(time, formatter));
        return customDate;
    }

    public static CustomDate custom(String time, String format) {
        //
        CustomDate customDate = new CustomDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        customDate.setTime(LocalDateTime.parse(time, formatter));
        return customDate;
    }

    public static CustomDate custom(String time, ZoneId zoneId) {
        //
        CustomDate customDate = new CustomDate(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_STRING_DATE_FORMAT);
        customDate.setTime(LocalDateTime.parse(time, formatter));
        return customDate;
    }

    public static CustomDate custom(String time, String format, ZoneId zoneId) {
        //
        CustomDate customDate = new CustomDate(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        customDate.setTime(LocalDateTime.parse(time, formatter));
        return customDate;
    }

    public void addSeconds(long seconds) {
        //
        if (seconds == 0L) {
            return;
        }

        if (seconds < 0L) {
            minusSeconds(seconds * -1);
            return;
        }

        this.time = this.time.plusSeconds(seconds);
    }

    public void minusSeconds(long seconds) {
        //
        if (seconds == 0L) {
            return;
        }

        if (seconds < 0L) {
            addSeconds(seconds * -1);
            return;
        }

        this.time = this.time.minusSeconds(seconds);
    }


    public void addMinutes(long minutes) {
        //
        if (minutes == 0L) {
            return;
        }

        if (minutes < 0L) {
            minusMinutes(minutes * -1);
            return;
        }

        this.time = this.time.plusMinutes(minutes);
    }

    public void minusMinutes(long minutes) {
        //
        if (minutes == 0L) {
            return;
        }

        if (minutes < 0L) {
            addMinutes(minutes * -1);
            return;
        }

        this.time = this.time.minusMinutes(minutes);
    }


    public void addHours(long hour) {
        //
        if (hour == 0L) {
            return;
        }

        if (hour < 0L) {
            minusHours(hour * -1);
            return;
        }

        this.time = this.time.plusHours(hour);
    }

    public void minusHours(long hour) {
        //
        if (hour == 0L) {
            return;
        }

        if (hour < 0L) {
            addHours(hour * -1);
            return;
        }

        this.time = this.time.minusHours(hour);
    }


    public void addDays(long days) {
        //
        if (days == 0L) {
            return;
        }

        if (days < 0L) {
            minusDays(days * -1);
            return;
        }

        this.time = this.time.plusDays(days);
    }

    public void minusDays(long days) {
        //
        if (days == 0L) {
            return;
        }

        if (days < 0L) {
            addDays(days * -1);
            return;
        }

        this.time = this.time.minusDays(days);
    }

    public void addWeeks(long weeks) {
        //
        if (weeks == 0L) {
            return;
        }

        if (weeks < 0L) {
            minusWeeks(weeks * -1);
            return;
        }

        this.time = this.time.plusWeeks(weeks);
    }

    public void minusWeeks(long weeks) {
        //
        if (weeks == 0L) {
            return;
        }

        if (weeks < 0L) {
            addWeeks(weeks * -1);
            return;
        }

        this.time = this.time.minusWeeks(weeks);
    }

    public void addMonths(long months) {
        //
        if (months == 0L) {
            return;
        }

        if (months < 0L) {
            minusMonths(months * -1);
            return;
        }

        this.time = this.time.plusMonths(months);
    }

    public void minusMonths(long months) {
        //
        if (months == 0L) {
            return;
        }

        if (months < 0L) {
            addMonths(months * -1);
            return;
        }

        this.time = this.time.minusMonths(months);
    }

    public void addYears(long years) {
        //
        if (years == 0L) {
            return;
        }

        if (years < 0L) {
            minusYears(years * -1);
            return;
        }

        this.time = this.time.plusYears(years);
    }

    public void minusYears(long days) {
        //
        if (days == 0L) {
            return;
        }

        if (days < 0L) {
            addYears(days * -1);
            return;
        }

        this.time = this.time.minusYears(days);
    }

    public void startOfDay() {
        //
        this.time = this.time.with(LocalTime.MIN);
    }

    public void endOfDay() {
        //
        this.time = this.time.with(LocalTime.MAX);
    }

    public LocalDateTime toLocalDateTime() {
        //
        return this.time;
    }

    public LocalDate toLocalDate() {
        //
        return this.time.toLocalDate();
    }

    public long toMilliSeconds() {
        //
        return this.time.atZone(this.zoneId).toEpochSecond() * 1000;
    }

    public long toSeconds() {
        //
        return this.time.atZone(this.zoneId).toEpochSecond();
    }

    public Date toDate() {
        //
        Instant instant = this.time.atZone(this.zoneId).toInstant();
        return Date.from(instant);
    }

    public String toStringTime() {
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_STRING_TIME_FORMAT);
        return time.format(formatter);
    }

    public String toStringTime(String format) {
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return time.format(formatter);
    }

    public String toStringDate() {
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_STRING_DATE_FORMAT);
        return toLocalDate().format(formatter);
    }

    public String toStringDate(String format) {
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return toLocalDate().format(formatter);
    }
}
