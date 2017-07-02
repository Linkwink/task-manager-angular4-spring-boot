package ua.com.hromoi.domain.utils;

import java.sql.Timestamp;


/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class TimestampValidator {

    public static boolean isValid(Long timestamp) {
        Timestamp currTimestamp = new Timestamp(System.currentTimeMillis());
        return (currTimestamp.getTime() >= timestamp)? true : false;
    }
}
