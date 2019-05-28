package com.tencent.p177mm.plugin.webview.p768b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.b.c */
public final class C7615c extends C7563j<C35580a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C35580a.ccO, "WebViewData")};

    static {
        AppMethodBeat.m2504i(5644);
        AppMethodBeat.m2505o(5644);
    }

    public C7615c(C4927e c4927e) {
        super(c4927e, C35580a.ccO, "WebViewData", null);
    }

    /* renamed from: gW */
    public final long mo17060gW(String str, String str2) {
        long j = 0;
        AppMethodBeat.m2504i(5636);
        Cursor rawQuery = rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", C7615c.m13543gY(str, str2)}), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(5636);
        } else {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(5636);
        }
        return j;
    }

    /* renamed from: gV */
    public final C35580a mo17059gV(String str, String str2) {
        AppMethodBeat.m2504i(5637);
        Cursor gX = m13542gX(str, str2);
        C35580a c35580a = new C35580a();
        if (gX != null) {
            if (gX.moveToFirst()) {
                c35580a.mo8995d(gX);
            }
            gX.close();
        }
        AppMethodBeat.m2505o(5637);
        return c35580a;
    }

    /* renamed from: gX */
    private Cursor m13542gX(String str, String str2) {
        AppMethodBeat.m2504i(5638);
        String format = String.format("select * from %s where %s=\"%s\"", new Object[]{"WebViewData", "appIdKey", C7615c.m13543gY(str, str2)});
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "getData: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        AppMethodBeat.m2505o(5638);
        return rawQuery;
    }

    /* renamed from: b */
    public final void mo17058b(String str, JSONArray jSONArray) {
        AppMethodBeat.m2504i(5639);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(5639);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                stringBuilder.append("\"" + C7615c.m13543gY(str, jSONArray.getString(i)) + "\",");
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewDataStorage", "clearData: " + e.getMessage());
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        String format = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "deleteData: ".concat(String.valueOf(format)));
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "clearData: ".concat(String.valueOf(mo16768hY("WebViewData", format))));
        AppMethodBeat.m2505o(5639);
    }

    public final void adY(String str) {
        AppMethodBeat.m2504i(5640);
        String format = String.format("delete from %s where %s=\"%s\"", new Object[]{"WebViewData", "appId", str});
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(format)));
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(mo16768hY("WebViewData", format))));
        AppMethodBeat.m2505o(5640);
    }

    /* renamed from: at */
    static String m13541at(String str, String str2, String str3) {
        AppMethodBeat.m2504i(5641);
        String str4 = str + str3 + str2;
        AppMethodBeat.m2505o(5641);
        return str4;
    }

    public final long adZ(String str) {
        AppMethodBeat.m2504i(5642);
        String format = String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", C7615c.m13541at(str, "###@@@@TOTAL@@@###SIZE####", "_")});
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(format)));
        long j = 0;
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        C4990ab.m7410d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(5642);
        return j;
    }

    /* renamed from: gY */
    static String m13543gY(String str, String str2) {
        AppMethodBeat.m2504i(5643);
        String str3 = str + "_" + str2;
        AppMethodBeat.m2505o(5643);
        return str3;
    }
}
