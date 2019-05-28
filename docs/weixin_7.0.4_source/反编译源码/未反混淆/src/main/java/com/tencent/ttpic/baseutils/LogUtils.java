package com.tencent.ttpic.baseutils;

import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogUtils {
    private static boolean isLogcatEnable = false;
    private static long mInitTime;
    private static long mLastTime;
    private static LruCache<String, Long> mTimeStampMap = new LruCache(1000);
    private static final Configuration sConfiguration = new Configuration();

    static {
        AppMethodBeat.i(49786);
        AppMethodBeat.o(49786);
    }

    public static void setLogcatEnable(boolean z) {
        isLogcatEnable = z;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(49766);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.o(49766);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49767);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49767);
    }

    public static void v(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.i(49768);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49768);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(49769);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.o(49769);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49770);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49770);
    }

    public static void i(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.i(49771);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49771);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(49772);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.o(49772);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49773);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49773);
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.i(49774);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49774);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(49775);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.o(49775);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49776);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49776);
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.i(49777);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49777);
    }

    public static void e(Throwable th) {
        AppMethodBeat.i(49778);
        e("", th.getMessage());
        AppMethodBeat.o(49778);
    }

    public static void e(String str, Throwable th) {
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(49779);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.o(49779);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49780);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49780);
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.i(49781);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.o(49781);
    }

    public static void printTime(String str, String str2) {
        AppMethodBeat.i(49782);
        if (!isLogcatEnable || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(49782);
        } else if (str2.contains("BEGIN")) {
            mTimeStampMap.put(str, Long.valueOf(System.currentTimeMillis()));
            i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2);
            AppMethodBeat.o(49782);
        } else if (str2.contains("END")) {
            long longValue;
            Long l = (Long) mTimeStampMap.get(str);
            if (l != null) {
                longValue = l.longValue();
            } else {
                longValue = System.currentTimeMillis();
            }
            i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2 + " = " + (System.currentTimeMillis() - longValue));
            AppMethodBeat.o(49782);
        } else {
            i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2);
            AppMethodBeat.o(49782);
        }
    }

    private static long initTime() {
        AppMethodBeat.i(49783);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        mLastTime = currentThreadTimeMillis;
        mInitTime = currentThreadTimeMillis;
        currentThreadTimeMillis = mLastTime;
        AppMethodBeat.o(49783);
        return currentThreadTimeMillis;
    }

    private static String getFormatMessage(String str, String str2, Object... objArr) {
        AppMethodBeat.i(49784);
        if (objArr != null) {
            try {
                str2 = String.format(sConfiguration.locale, str2, objArr);
            } catch (Exception e) {
            }
        }
        String str3 = generateLogPrefix(str) + str2;
        AppMethodBeat.o(49784);
        return str3;
    }

    private static String generateLogPrefix(String str) {
        AppMethodBeat.i(49785);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str2;
        if (stackTrace == null) {
            str2 = "";
            AppMethodBeat.o(49785);
            return str2;
        }
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || !stackTraceElement.getClassName().endsWith(str)) {
                i++;
            } else {
                str2 = "(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]: ";
                AppMethodBeat.o(49785);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(49785);
        return str2;
    }
}
