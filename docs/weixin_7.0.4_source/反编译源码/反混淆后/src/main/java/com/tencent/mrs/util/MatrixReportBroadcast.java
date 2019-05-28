package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MatrixReportBroadcast extends BroadcastReceiver {
    private static final HashMap<String, ArrayList<C5777a>> AjR = new HashMap();

    /* renamed from: com.tencent.mrs.util.MatrixReportBroadcast$1 */
    static class C57761 implements IdleHandler {
        C57761() {
        }

        public final boolean queueIdle() {
            for (String str : MatrixReportBroadcast.AjR.keySet()) {
                C1070c.m2368i("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) MatrixReportBroadcast.AjR.get((String) r2.next())).size()));
                Iterator it = r1.iterator();
                while (it.hasNext()) {
                    C5777a c5777a = (C5777a) it.next();
                    MatrixReport.with().reportLocal(c5777a.tag, c5777a.value);
                }
            }
            MatrixReportBroadcast.AjR.clear();
            return false;
        }
    }

    /* renamed from: com.tencent.mrs.util.MatrixReportBroadcast$a */
    static class C5777a {
        String tag;
        String value;

        C5777a(String str, String str2) {
            this.tag = str;
            this.value = str2;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C1070c.m2367e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
            return;
        }
        String n = C5068w.m7689n(intent, "tag");
        String n2 = C5068w.m7689n(intent, "value");
        if (MatrixReport.isInstalled()) {
            C1070c.m2368i("Matrix.ReportBroadcast", "MatrixReportBroadcast, receive broadcast with tag %s, value:%s", n, n2);
            MatrixReport.with().reportLocal(n, n2);
            return;
        }
        C1070c.m2367e("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s, content:%s", n, n2);
        C5777a c5777a = new C5777a(n, n2);
        ArrayList arrayList = (ArrayList) AjR.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(c5777a);
    }

    public static void dPd() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new C57761());
    }
}
