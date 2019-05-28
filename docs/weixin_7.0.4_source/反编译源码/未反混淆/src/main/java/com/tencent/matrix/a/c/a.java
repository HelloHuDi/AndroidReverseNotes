package com.tencent.matrix.a.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class a {
    private static String bWa = null;
    private static String sPackageName = null;

    public static void setPackageName(Context context) {
        if (sPackageName == null) {
            sPackageName = context.getPackageName();
        }
    }

    public static void ce(String str) {
        bWa = str;
    }

    public static String getProcessName() {
        return bWa;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static String getThrowableStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (int i = 0; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!(className.contains("com.tencent.matrix") || className.contains("java.lang.reflect") || className.contains("$Proxy2") || className.contains("android.os"))) {
                arrayList.add(stackTrace[i]);
            }
        }
        if (arrayList.size() > 10 && sPackageName != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(sPackageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 10) {
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((StackTraceElement) it.next()).append(10);
        }
        return stringBuffer.toString();
    }
}
