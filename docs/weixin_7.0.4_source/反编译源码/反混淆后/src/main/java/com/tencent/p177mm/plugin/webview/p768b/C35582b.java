package com.tencent.p177mm.plugin.webview.p768b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.webview.p1562a.C40211a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.b.b */
public final class C35582b {
    private static long ueF = 2592000;
    private static C35582b ueG;
    private C7615c ueH;
    private Map<String, Long> ueI = new HashMap();
    private long ueJ = 0;

    public C35582b() {
        AppMethodBeat.m2504i(5625);
        AppMethodBeat.m2505o(5625);
    }

    public static C35582b cWi() {
        AppMethodBeat.m2504i(5626);
        if (ueG == null) {
            ueG = new C35582b();
        }
        C35582b c35582b = ueG;
        AppMethodBeat.m2505o(5626);
        return c35582b;
    }

    public final C7615c cWj() {
        AppMethodBeat.m2504i(5627);
        if (this.ueH == null) {
            C1720g.m3537RQ();
            this.ueH = new C7615c(C1720g.m3536RP().eJN);
        }
        C7615c c7615c = this.ueH;
        AppMethodBeat.m2505o(5627);
        return c7615c;
    }

    /* renamed from: a */
    public final boolean mo56311a(String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.m2504i(5628);
        long length = (long) (str2.getBytes().length + str3.getBytes().length);
        final long adZ = adZ(str) + (length - cWj().mo17060gW(str, str2));
        final long ax = C35582b.m58408ax(str, adZ);
        C4990ab.m7417i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", Long.valueOf(r2), Long.valueOf(length), Long.valueOf(r12), Long.valueOf(adZ), Long.valueOf(ax));
        if (ax <= 0 || z) {
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str4;
            final String str10 = str5;
            C40211a.m68966R(new Runnable() {
                public final void run() {
                    long j;
                    AppMethodBeat.m2504i(5624);
                    if (ax > 0) {
                        C7615c cWj = C35582b.this.cWj();
                        String str = str6;
                        long j2 = ax;
                        str = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[]{"WebViewData", str});
                        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "deleteSize querySql: ".concat(String.valueOf(str)));
                        Cursor rawQuery = cWj.rawQuery(str, new String[0]);
                        if (rawQuery == null) {
                            j = 0;
                        } else {
                            LinkedList<String> linkedList = new LinkedList();
                            long j3 = j2;
                            while (rawQuery.moveToFirst() && j3 > 0) {
                                str = rawQuery.getString(1);
                                long j4 = rawQuery.getLong(6);
                                linkedList.add(str);
                                j3 -= j4;
                            }
                            rawQuery.close();
                            if (linkedList.size() > 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("(");
                                for (String str2 : linkedList) {
                                    stringBuilder.append("\"" + str2 + "\",");
                                }
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                                stringBuilder.append(")");
                                str2 = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
                                C4990ab.m7410d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: ".concat(String.valueOf(str2)));
                                C4990ab.m7410d("MicroMsg.WebViewDataStorage", "deleteSize: ".concat(String.valueOf(cWj.mo16768hY("WebViewData", str2))));
                            }
                            j = j2 - j3;
                        }
                        C35582b.this.ueI.put(str6, Long.valueOf(adZ - j));
                    } else {
                        C35582b.this.ueI.put(str6, Long.valueOf(adZ));
                    }
                    C7615c cWj2 = C35582b.this.cWj();
                    String str3 = str6;
                    String str4 = str7;
                    String str5 = str8;
                    String bc = C5046bo.m7532bc(str9, "1");
                    long aea = C35582b.aea(str10);
                    C35580a c35580a = new C35580a();
                    c35580a.field_appId = str3;
                    c35580a.field_appIdKey = C7615c.m13543gY(str3, str4);
                    c35580a.field_value = str5;
                    c35580a.field_weight = bc;
                    c35580a.field_expireTime = aea + (System.currentTimeMillis() / 1000);
                    c35580a.field_size = (long) (str4.getBytes().length + str5.getBytes().length);
                    c35580a.field_timeStamp = System.currentTimeMillis() / 1000;
                    C4990ab.m7410d("MicroMsg.WebViewDataStorage", "setData: ".concat(String.valueOf(cWj2.mo10099a(c35580a))));
                    C7615c cWj3 = C35582b.this.cWj();
                    str5 = str6;
                    if (C35582b.this.ueI.get(str6) == null) {
                        j = 0;
                    } else {
                        j = ((Long) C35582b.this.ueI.get(str6)).longValue();
                    }
                    C35580a c35580a2 = new C35580a();
                    c35580a2.field_appId = str5;
                    c35580a2.field_appIdKey = C7615c.m13541at(str5, "###@@@@TOTAL@@@###SIZE####", "_");
                    c35580a2.field_expireTime = Long.MAX_VALUE;
                    c35580a2.field_size = j;
                    boolean a = cWj3.mo10099a(c35580a2);
                    C4990ab.m7411d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", Boolean.valueOf(a), Long.valueOf(j));
                    C35582b.m58409b(C35582b.this);
                    AppMethodBeat.m2505o(5624);
                }
            });
            AppMethodBeat.m2505o(5628);
            return true;
        }
        AppMethodBeat.m2505o(5628);
        return false;
    }

    /* renamed from: gV */
    public final C35580a mo56315gV(String str, String str2) {
        AppMethodBeat.m2504i(5629);
        C35580a gV = cWj().mo17059gV(str, str2);
        AppMethodBeat.m2505o(5629);
        return gV;
    }

    /* renamed from: b */
    public final void mo56313b(String str, JSONArray jSONArray) {
        AppMethodBeat.m2504i(5630);
        cWj().mo17058b(str, jSONArray);
        AppMethodBeat.m2505o(5630);
    }

    public final void adY(String str) {
        AppMethodBeat.m2504i(5631);
        cWj().adY(str);
        AppMethodBeat.m2505o(5631);
    }

    private long adZ(String str) {
        AppMethodBeat.m2504i(5632);
        long longValue;
        if (this.ueI.containsKey(str)) {
            longValue = ((Long) this.ueI.get(str)).longValue();
            AppMethodBeat.m2505o(5632);
            return longValue;
        }
        longValue = cWj().adZ(str);
        AppMethodBeat.m2505o(5632);
        return longValue;
    }

    /* renamed from: ax */
    private static long m58408ax(String str, long j) {
        AppMethodBeat.m2504i(5633);
        long j2;
        if (str.equals("wx62d9035fd4fd2059")) {
            j2 = j - 52428800;
            AppMethodBeat.m2505o(5633);
            return j2;
        }
        j2 = j - 10485760;
        AppMethodBeat.m2505o(5633);
        return j2;
    }

    static /* synthetic */ long aea(String str) {
        AppMethodBeat.m2504i(5634);
        long j = C5046bo.getLong(str, 604800);
        if (j > ueF) {
            j = ueF;
            AppMethodBeat.m2505o(5634);
            return j;
        }
        AppMethodBeat.m2505o(5634);
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ void m58409b(C35582b c35582b) {
        AppMethodBeat.m2504i(5635);
        C7615c cWj = c35582b.cWj();
        String format = String.format("delete from %s where %s<%s", new Object[]{"WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)});
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: ".concat(String.valueOf(format)));
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: ".concat(String.valueOf(cWj.mo16768hY("WebViewData", format))));
        AppMethodBeat.m2505o(5635);
    }
}
