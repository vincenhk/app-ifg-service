package com.exam.ifg.service.common;

import jakarta.ws.rs.core.Response;

import java.time.ZoneId;

public class Constant {

    //HTTP STATUS
    public static final int OK = Response.Status.OK.getStatusCode(); // 200
    public static final int CREATED = Response.Status.CREATED.getStatusCode(); // 201
    public static final int NO_CONTENT = Response.Status.NO_CONTENT.getStatusCode(); // 204
    public static final int BAD_REQUEST = Response.Status.BAD_REQUEST.getStatusCode(); // 400
    public static final int UNAUTHORIZED = Response.Status.UNAUTHORIZED.getStatusCode(); // 401
    public static final int FORBIDDEN = Response.Status.FORBIDDEN.getStatusCode(); // 403
    public static final int NOT_FOUND = Response.Status.NOT_FOUND.getStatusCode(); // 404
    public static final int METHOD_NOT_ALLOWED = Response.Status.METHOD_NOT_ALLOWED.getStatusCode(); // 405
    public static final int CONFLICT = Response.Status.CONFLICT.getStatusCode(); // 409
    public static final int UNSUPPORTED_MEDIA_TYPE = Response.Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode(); // 415
    public static final int INTERNAL_SERVER_ERROR = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(); // 500
    public static final int NOT_IMPLEMENTED = Response.Status.NOT_IMPLEMENTED.getStatusCode(); // 501
    public static final int BAD_GATEWAY = Response.Status.BAD_GATEWAY.getStatusCode(); // 502
    public static final int SERVICE_UNAVAILABLE = Response.Status.SERVICE_UNAVAILABLE.getStatusCode(); // 503

    // Format used
    public static final String MONTH_YEAR = "MM_yyyy";
    public static final String DAY_TIME = "dd-HH:mm";
    public static final String FULL_DATE = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR = "yyyy";
    public static final String DAY_MONTH = "dd-MM";

    // Format TimeZone
    public static final ZoneId UTC = ZoneId.of("UTC");
    public static final ZoneId GMT = ZoneId.of("GMT");
    public static final ZoneId AMERICA_NEW_YORK = ZoneId.of("America/New_York");
    public static final ZoneId EUROPE_LONDON = ZoneId.of("Europe/London");
    public static final ZoneId ASIA_JAKARTA = ZoneId.of("Asia/Jakarta");
    public static final ZoneId EUROPE_PARIS = ZoneId.of("Europe/Paris");

    // Status
    public static final String SUCCESS_STATUS = "SUCCESS";
    public static final String FAILED_STATUS = "FAILED";
}
