package ua.com.hromoi.domain.utils;


import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class TimestampValidator {

    public static boolean isValid(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.of("Etc/GMT+3");
        LocalDateTime nowTime = LocalDateTime.now();
        return (nowTime.atZone(zoneId).toEpochSecond() <= dateTime.atZone(zoneId).toEpochSecond())? true : false;
    }
}
