package ru.progwards.pvv.lesson16;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Lesson16test {
    public static void main(String[] args) {
        LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());

        LocalDateTime ldt3= LocalDateTime.of(2019, 05, 05, 22, 24);
        System.out.println(ldt3);

        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));
    }
}
