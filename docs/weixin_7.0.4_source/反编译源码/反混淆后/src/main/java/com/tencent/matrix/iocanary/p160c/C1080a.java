package com.tencent.matrix.iocanary.p160c;

import android.content.Context;
import com.tencent.matrix.iocanary.core.IOIssue;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.matrix.iocanary.c.a */
public final class C1080a {
    private static String sPackageName = null;

    public static void setPackageName(Context context) {
        if (sPackageName == null) {
            sPackageName = context.getPackageName();
        }
    }

    public static String getThrowableStack(Throwable th) {
        if (th == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (int i = 0; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!(className.contains("libcore.io") || className.contains("com.tencent.matrix.iocanary") || className.contains("java.io") || className.contains("dalvik.system") || className.contains("android.os"))) {
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

    /* renamed from: a */
    public static C1062b m2386a(IOIssue iOIssue) {
        if (iOIssue == null) {
            return null;
        }
        C1062b c1062b = new C1062b(iOIssue.type);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", iOIssue.path);
            jSONObject.put("size", iOIssue.fileSize);
            jSONObject.put("op", iOIssue.opCnt);
            jSONObject.put("buffer", iOIssue.bufferSize);
            jSONObject.put("cost", iOIssue.opCostTime);
            jSONObject.put("opType", iOIssue.opType);
            jSONObject.put("opSize", iOIssue.opSize);
            jSONObject.put("thread", iOIssue.threadName);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, iOIssue.stack);
            jSONObject.put("repeat", iOIssue.repeatReadCnt);
        } catch (JSONException e) {
        }
        c1062b.bWv = jSONObject;
        return c1062b;
    }
}
