package com.tencent.pb.common.c;

import com.google.a.a.e;
import com.tencent.pb.common.b.a;
import com.tencent.pb.common.b.a.a.c;
import com.tencent.pb.common.b.a.a.w;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class f {
    private static HashMap<String, String> ApZ = new HashMap();
    private static Object sLock = new Object();

    public static void C(int i, int i2, String str) {
        if (str == null) {
            c.w("gyz", "addEmergencyRecord value is null");
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            stringBuffer.append("---");
            stringBuffer.append(i2);
            synchronized (sLock) {
                Object str2;
                String str3 = (String) ApZ.get(stringBuffer.toString());
                if (str3 != null && str3.length() > 0) {
                    StringBuffer stringBuffer2 = new StringBuffer(str3);
                    stringBuffer2.append("---");
                    stringBuffer2.append(str2);
                    str2 = stringBuffer2.toString();
                }
                ApZ.put(stringBuffer.toString(), str2);
            }
        } catch (Throwable th) {
            c.w("gyz", th);
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0017, code skipped:
            r3 = new java.lang.StringBuffer();
            r4 = r0.iterator();
     */
    /* JADX WARNING: Missing block: B:11:0x0024, code skipped:
            if (r4.hasNext() == false) goto L_0x0015;
     */
    /* JADX WARNING: Missing block: B:12:0x0026, code skipped:
            r0 = (java.lang.String) r4.next();
            r1 = r0.split("---");
     */
    /* JADX WARNING: Missing block: B:13:0x0034, code skipped:
            if (r1.length < 2) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:14:0x0036, code skipped:
            r5 = r1[0];
            r6 = r1[1];
            r1 = sLock;
     */
    /* JADX WARNING: Missing block: B:15:0x003c, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            r0 = (java.lang.String) ApZ.get(r0);
     */
    /* JADX WARNING: Missing block: B:18:0x0045, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:19:0x0046, code skipped:
            if (r0 == null) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:21:0x004c, code skipped:
            if (r0.length() == 0) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:22:0x004e, code skipped:
            r7 = r0.split("---");
     */
    /* JADX WARNING: Missing block: B:23:0x0055, code skipped:
            if (r7 == null) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:25:0x0058, code skipped:
            if (r7.length == 0) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:26:0x005a, code skipped:
            r8 = r7.length;
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:27:0x005c, code skipped:
            if (r1 >= r8) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:28:0x005e, code skipped:
            r0 = r7[r1];
     */
    /* JADX WARNING: Missing block: B:29:0x0060, code skipped:
            if (r0 == null) goto L_0x0093;
     */
    /* JADX WARNING: Missing block: B:31:0x0066, code skipped:
            if (r0.length() == 0) goto L_0x0093;
     */
    /* JADX WARNING: Missing block: B:32:0x0068, code skipped:
            r9 = r0.split("%");
     */
    /* JADX WARNING: Missing block: B:33:0x0070, code skipped:
            if (r9.length != 2) goto L_0x0074;
     */
    /* JADX WARNING: Missing block: B:34:0x0072, code skipped:
            r0 = r9[1];
     */
    /* JADX WARNING: Missing block: B:35:0x0074, code skipped:
            r9 = new com.tencent.pb.common.b.a.a.w();
            r9.AnO = r5;
            r3.setLength(0);
            r3.append(r6);
            r3.append("%");
            r3.append(r0);
            r9.AnP = r3.toString();
            r13.add(r9);
     */
    /* JADX WARNING: Missing block: B:36:0x0093, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:63:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void as(ArrayList<w> arrayList) {
        synchronized (sLock) {
            Set keySet = ApZ.keySet();
            if (keySet == null || keySet.size() <= 0) {
            }
        }
    }

    public static void clearData() {
        synchronized (sLock) {
            ApZ.clear();
        }
    }

    public static void dPL() {
        if (h.isNetworkConnected()) {
            e cVar;
            ArrayList arrayList = new ArrayList();
            as(arrayList);
            if (arrayList.size() > 0) {
                cVar = new c();
                w[] wVarArr = new w[arrayList.size()];
                arrayList.toArray(wVarArr);
                cVar.Amy = wVarArr;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                c.w("StatisticsUtil", "reportStatisticsData CSClientReportReq is null");
                return;
            }
            c.w("yunying", "reportStatisticsData");
            int a = com.tencent.pb.common.b.f.dPx().a(new a() {
                public final void eM(String str, int i) {
                    if ("CsCmd.Cmd_CSClientReportReq".equals(str)) {
                        if (i == 0) {
                            f.clearData();
                        }
                        c.w("yunying", "reportStatisticsData isCommonData:  errCode: ".concat(String.valueOf(i)));
                    }
                }
            }, "CsCmd.Cmd_CSClientReportReq", cVar);
            c.d("StatisticsUtil", "reportStatisticsData start ret: ", Integer.valueOf(a));
            return;
        }
        c.w("StatisticsUtil", "reportStatisticsData network is false");
    }
}
