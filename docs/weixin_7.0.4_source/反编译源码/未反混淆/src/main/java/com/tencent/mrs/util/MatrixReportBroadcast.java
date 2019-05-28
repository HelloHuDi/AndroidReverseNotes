package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.d.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MatrixReportBroadcast extends BroadcastReceiver {
    private static final HashMap<String, ArrayList<a>> AjR = new HashMap();

    static class a {
        String tag;
        String value;

        a(String str, String str2) {
            this.tag = str;
            this.value = str2;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
            return;
        }
        String n = w.n(intent, "tag");
        String n2 = w.n(intent, "value");
        if (MatrixReport.isInstalled()) {
            c.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, receive broadcast with tag %s, value:%s", n, n2);
            MatrixReport.with().reportLocal(n, n2);
            return;
        }
        c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s, content:%s", n, n2);
        a aVar = new a(n, n2);
        ArrayList arrayList = (ArrayList) AjR.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(aVar);
    }

    public static void dPd() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                for (String str : MatrixReportBroadcast.AjR.keySet()) {
                    c.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) MatrixReportBroadcast.AjR.get((String) r2.next())).size()));
                    Iterator it = r1.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        MatrixReport.with().reportLocal(aVar.tag, aVar.value);
                    }
                }
                MatrixReportBroadcast.AjR.clear();
                return false;
            }
        });
    }
}
