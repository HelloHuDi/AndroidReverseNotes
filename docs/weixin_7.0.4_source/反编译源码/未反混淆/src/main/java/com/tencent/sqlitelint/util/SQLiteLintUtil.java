package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.BuildConfig;
import com.tencent.sqlitelint.SQLiteLint;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class SQLiteLintUtil {
    private static final int DEFAULT_MAX_STACK_LAYER = 6;
    private static final String TAG = "SQLiteLint.SQLiteLintUtil";
    public static final String YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(94121);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(94121);
            return true;
        }
        AppMethodBeat.o(94121);
        return false;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static String extractDbName(String str) {
        String str2 = null;
        AppMethodBeat.i(94122);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(94122);
        } else {
            String[] split = str.split("/");
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            AppMethodBeat.o(94122);
        }
        return str2;
    }

    public static int getInt(String str, int i) {
        AppMethodBeat.i(94123);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.o(94123);
                    return i;
                }
            } catch (NumberFormatException e) {
                AppMethodBeat.o(94123);
            }
        }
        AppMethodBeat.o(94123);
        return i;
    }

    public static String formatTime(String str, long j) {
        AppMethodBeat.i(94124);
        String format = new SimpleDateFormat(str).format(new Date(j));
        AppMethodBeat.o(94124);
        return format;
    }

    public static void mkdirs(String str) {
        AppMethodBeat.i(94125);
        File file = new File(str);
        if (!file.exists()) {
            file = file.getParentFile();
            if (file != null) {
                file.mkdirs();
            }
        }
        AppMethodBeat.o(94125);
    }

    public static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(94126);
        String str;
        if (stackTraceElementArr == null) {
            str = "";
            AppMethodBeat.o(94126);
            return str;
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (!stackTraceElementArr[i].getClassName().contains(BuildConfig.APPLICATION_ID)) {
                arrayList.add(stackTraceElementArr[i]);
            }
        }
        if (arrayList.size() > 6 && SQLiteLint.sPackageName != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(SQLiteLint.sPackageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 6) {
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((StackTraceElement) it.next()).append(10);
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(94126);
        return str;
    }

    public static String getThrowableStack(Throwable th) {
        AppMethodBeat.i(94127);
        String str;
        if (th == null) {
            str = "";
            AppMethodBeat.o(94127);
            return str;
        }
        str = stackTraceToString(th.getStackTrace());
        AppMethodBeat.o(94127);
        return str;
    }

    public static String getThrowableStack() {
        AppMethodBeat.i(94128);
        String throwableStack;
        try {
            throwableStack = getThrowableStack(new Throwable());
            AppMethodBeat.o(94128);
            return throwableStack;
        } catch (Throwable th) {
            SLog.e(TAG, "getThrowableStack ex %s", th.getMessage());
            throwableStack = "";
            AppMethodBeat.o(94128);
            return throwableStack;
        }
    }
}
