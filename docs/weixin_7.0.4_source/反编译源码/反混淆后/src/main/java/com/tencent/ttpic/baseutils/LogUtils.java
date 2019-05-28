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
        AppMethodBeat.m2504i(49786);
        AppMethodBeat.m2505o(49786);
    }

    public static void setLogcatEnable(boolean z) {
        isLogcatEnable = z;
    }

    /* renamed from: v */
    public static void m50210v(String str, String str2) {
        AppMethodBeat.m2504i(49766);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.m2505o(49766);
    }

    /* renamed from: v */
    public static void m50212v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49767);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49767);
    }

    /* renamed from: v */
    public static void m50211v(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(49768);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49768);
    }

    /* renamed from: i */
    public static void m50207i(String str, String str2) {
        AppMethodBeat.m2504i(49769);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.m2505o(49769);
    }

    /* renamed from: i */
    public static void m50209i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49770);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49770);
    }

    /* renamed from: i */
    public static void m50208i(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(49771);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49771);
    }

    /* renamed from: d */
    public static void m50199d(String str, String str2) {
        AppMethodBeat.m2504i(49772);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.m2505o(49772);
    }

    /* renamed from: d */
    public static void m50201d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49773);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49773);
    }

    /* renamed from: d */
    public static void m50200d(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(49774);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49774);
    }

    /* renamed from: w */
    public static void m50213w(String str, String str2) {
        AppMethodBeat.m2504i(49775);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.m2505o(49775);
    }

    /* renamed from: w */
    public static void m50215w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49776);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49776);
    }

    /* renamed from: w */
    public static void m50214w(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(49777);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49777);
    }

    /* renamed from: e */
    public static void m50206e(Throwable th) {
        AppMethodBeat.m2504i(49778);
        m50202e("", th.getMessage());
        AppMethodBeat.m2505o(49778);
    }

    /* renamed from: e */
    public static void m50205e(String str, Throwable th) {
    }

    /* renamed from: e */
    public static void m50202e(String str, String str2) {
        AppMethodBeat.m2504i(49779);
        if (isLogcatEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder().append("(" + Thread.currentThread().getName() + ")" + stackTraceElement.getClassName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + "]").append(": ").append(str2);
        }
        AppMethodBeat.m2505o(49779);
    }

    /* renamed from: e */
    public static void m50204e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49780);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49780);
    }

    /* renamed from: e */
    public static void m50203e(String str, String str2, Throwable th, Object... objArr) {
        AppMethodBeat.m2504i(49781);
        if (isLogcatEnable) {
            getFormatMessage(str, str2, objArr);
        }
        AppMethodBeat.m2505o(49781);
    }

    public static void printTime(String str, String str2) {
        AppMethodBeat.m2504i(49782);
        if (!isLogcatEnable || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(49782);
        } else if (str2.contains("BEGIN")) {
            mTimeStampMap.put(str, Long.valueOf(System.currentTimeMillis()));
            m50207i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2);
            AppMethodBeat.m2505o(49782);
        } else if (str2.contains("END")) {
            long longValue;
            Long l = (Long) mTimeStampMap.get(str);
            if (l != null) {
                longValue = l.longValue();
            } else {
                longValue = System.currentTimeMillis();
            }
            m50207i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2 + " = " + (System.currentTimeMillis() - longValue));
            AppMethodBeat.m2505o(49782);
        } else {
            m50207i("LOG_PERFORMANCE_".concat(String.valueOf(str)), str2);
            AppMethodBeat.m2505o(49782);
        }
    }

    private static long initTime() {
        AppMethodBeat.m2504i(49783);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        mLastTime = currentThreadTimeMillis;
        mInitTime = currentThreadTimeMillis;
        currentThreadTimeMillis = mLastTime;
        AppMethodBeat.m2505o(49783);
        return currentThreadTimeMillis;
    }

    private static String getFormatMessage(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(49784);
        if (objArr != null) {
            try {
                str2 = String.format(sConfiguration.locale, str2, objArr);
            } catch (Exception e) {
            }
        }
        String str3 = generateLogPrefix(str) + str2;
        AppMethodBeat.m2505o(49784);
        return str3;
    }

    private static String generateLogPrefix(String str) {
        AppMethodBeat.m2504i(49785);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str2;
        if (stackTrace == null) {
            str2 = "";
            AppMethodBeat.m2505o(49785);
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
                AppMethodBeat.m2505o(49785);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(49785);
        return str2;
    }
}
