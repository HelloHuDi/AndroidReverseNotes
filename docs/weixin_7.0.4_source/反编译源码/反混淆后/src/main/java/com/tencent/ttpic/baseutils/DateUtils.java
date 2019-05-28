package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    public static final SimpleDateFormat SERVER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    private static final String TAG = DateUtils.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(49668);
        AppMethodBeat.m2505o(49668);
    }

    public static long calcTimeCost(long j) {
        AppMethodBeat.m2504i(49653);
        long currentTimeMillis = System.currentTimeMillis() - j;
        AppMethodBeat.m2505o(49653);
        return currentTimeMillis;
    }

    public static String format(Date date) {
        AppMethodBeat.m2504i(49654);
        String format = DEFAULT_FORMAT.format(date);
        AppMethodBeat.m2505o(49654);
        return format;
    }

    public static synchronized String getNow2ServerFormat() {
        String format;
        synchronized (DateUtils.class) {
            AppMethodBeat.m2504i(49655);
            format = SERVER_DATE_FORMAT.format(new Date());
            AppMethodBeat.m2505o(49655);
        }
        return format;
    }

    public static String getCurrentFormatDate() {
        AppMethodBeat.m2504i(49656);
        String format = DEFAULT_DATE_FORMAT.format(new Date());
        AppMethodBeat.m2505o(49656);
        return format;
    }

    public static synchronized Date getServerDate(String str) {
        Date parse;
        synchronized (DateUtils.class) {
            AppMethodBeat.m2504i(49657);
            parse = parse(str, SERVER_DATE_FORMAT);
            AppMethodBeat.m2505o(49657);
        }
        return parse;
    }

    public static synchronized Date getDefaultDate(String str) {
        Date parse;
        synchronized (DateUtils.class) {
            AppMethodBeat.m2504i(49658);
            parse = parse(str, DEFAULT_FORMAT);
            AppMethodBeat.m2505o(49658);
        }
        return parse;
    }

    public static Date parse(String str, SimpleDateFormat simpleDateFormat) {
        AppMethodBeat.m2504i(49659);
        try {
            Date parse = simpleDateFormat.parse(str);
            AppMethodBeat.m2505o(49659);
            return parse;
        } catch (ParseException e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49659);
            return null;
        }
    }

    public static Date parse(String str, String str2) {
        AppMethodBeat.m2504i(49660);
        try {
            Date parse = new SimpleDateFormat(str2).parse(str);
            AppMethodBeat.m2505o(49660);
            return parse;
        } catch (ParseException e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49660);
            return null;
        }
    }

    public static Date parse(String str) {
        AppMethodBeat.m2504i(49661);
        try {
            Date parse = DEFAULT_FORMAT.parse(str);
            AppMethodBeat.m2505o(49661);
            return parse;
        } catch (ParseException e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49661);
            return null;
        }
    }

    public static int getCurrentYear() {
        AppMethodBeat.m2504i(49662);
        int i = Calendar.getInstance().get(1);
        AppMethodBeat.m2505o(49662);
        return i;
    }

    public static String buildClockFormatString(long j) {
        AppMethodBeat.m2504i(49663);
        String str;
        if (j < 0) {
            str = "0.0s";
            AppMethodBeat.m2505o(49663);
            return str;
        }
        double d = (double) (((float) j) / 1000.0f);
        str = String.format(Locale.US, "%.1fs", new Object[]{Double.valueOf(d)});
        AppMethodBeat.m2505o(49663);
        return str;
    }

    public static boolean isDateExpired(String str, String str2) {
        AppMethodBeat.m2504i(49664);
        Date defaultDate = getDefaultDate(str);
        Date defaultDate2 = getDefaultDate(str2);
        Date date = new Date();
        if (defaultDate == null || defaultDate2 == null || !date.after(defaultDate) || !date.before(defaultDate2)) {
            AppMethodBeat.m2505o(49664);
            return true;
        }
        AppMethodBeat.m2505o(49664);
        return false;
    }

    public static int daysBetween(String str, String str2) {
        AppMethodBeat.m2504i(49665);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            long timeInMillis = instance.getTimeInMillis();
            instance.setTime(parse2);
            int timeInMillis2 = (int) ((instance.getTimeInMillis() - timeInMillis) / 86400000);
            AppMethodBeat.m2505o(49665);
            return timeInMillis2;
        } catch (Exception e) {
            LogUtils.m50202e(TAG, e.getMessage());
            AppMethodBeat.m2505o(49665);
            return 0;
        }
    }

    public static boolean isDuringXChristmas() {
        boolean z = true;
        AppMethodBeat.m2504i(49666);
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        LogUtils.m50199d(TAG, "[isDuringXChristmas] year = ".concat(String.valueOf(i)));
        LogUtils.m50199d(TAG, "[isDuringXChristmas] month = ".concat(String.valueOf(i2)));
        LogUtils.m50199d(TAG, "[isDuringXChristmas] date = ".concat(String.valueOf(i3)));
        if (i != 2017) {
            z = false;
        } else if (11 != i2 || i3 < 22 || i3 > 26) {
            z = false;
        }
        LogUtils.m50207i(TAG, "[isDuringXChristmas] christmas = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49666);
        return z;
    }

    public static boolean isDuringNewYear() {
        boolean z = true;
        AppMethodBeat.m2504i(49667);
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        LogUtils.m50199d(TAG, "[isDuringNewYear] year = ".concat(String.valueOf(i)));
        LogUtils.m50199d(TAG, "[isDuringNewYear] month = ".concat(String.valueOf(i2)));
        LogUtils.m50199d(TAG, "[isDuringNewYear] date = ".concat(String.valueOf(i3)));
        if (i != 2018) {
            z = false;
        } else if (i2 != 0 || i3 <= 0 || i3 > 5) {
            z = false;
        }
        LogUtils.m50207i(TAG, "[isDuringNewYear] newYear = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(49667);
        return z;
    }
}
