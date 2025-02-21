package com.exam.ifg.service.util;

import com.exam.ifg.service.common.Constant;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {

    public static Timestamp currentTimeJakarta(){
        LocalDateTime now = LocalDateTime.now(Constant.ASIA_JAKARTA);
        return Timestamp.valueOf(now);
    }

    public static Timestamp convertStringToTimestamp(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FULL_DATE);
        Date parsedDate = dateFormat.parse(date);
        return new Timestamp(parsedDate.getTime());
    }
}
