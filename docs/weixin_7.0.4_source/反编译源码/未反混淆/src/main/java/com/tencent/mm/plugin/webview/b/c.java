package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;

public final class c extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "WebViewData")};

    static {
        AppMethodBeat.i(5644);
        AppMethodBeat.o(5644);
    }

    public c(e eVar) {
        super(eVar, a.ccO, "WebViewData", null);
    }

    public final long gW(String str, String str2) {
        long j = 0;
        AppMethodBeat.i(5636);
        Cursor rawQuery = rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", gY(str, str2)}), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(5636);
        } else {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            AppMethodBeat.o(5636);
        }
        return j;
    }

    public final a gV(String str, String str2) {
        AppMethodBeat.i(5637);
        Cursor gX = gX(str, str2);
        a aVar = new a();
        if (gX != null) {
            if (gX.moveToFirst()) {
                aVar.d(gX);
            }
            gX.close();
        }
        AppMethodBeat.o(5637);
        return aVar;
    }

    private Cursor gX(String str, String str2) {
        AppMethodBeat.i(5638);
        String format = String.format("select * from %s where %s=\"%s\"", new Object[]{"WebViewData", "appIdKey", gY(str, str2)});
        ab.d("MicroMsg.WebViewDataStorage", "getData: ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        AppMethodBeat.o(5638);
        return rawQuery;
    }

    public final void b(String str, JSONArray jSONArray) {
        AppMethodBeat.i(5639);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(5639);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                stringBuilder.append("\"" + gY(str, jSONArray.getString(i)) + "\",");
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewDataStorage", "clearData: " + e.getMessage());
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        String format = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
        ab.d("MicroMsg.WebViewDataStorage", "deleteData: ".concat(String.valueOf(format)));
        ab.d("MicroMsg.WebViewDataStorage", "clearData: ".concat(String.valueOf(hY("WebViewData", format))));
        AppMethodBeat.o(5639);
    }

    public final void adY(String str) {
        AppMethodBeat.i(5640);
        String format = String.format("delete from %s where %s=\"%s\"", new Object[]{"WebViewData", "appId", str});
        ab.d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(format)));
        ab.d("MicroMsg.WebViewDataStorage", "cleanAllData: ".concat(String.valueOf(hY("WebViewData", format))));
        AppMethodBeat.o(5640);
    }

    static String at(String str, String str2, String str3) {
        AppMethodBeat.i(5641);
        String str4 = str + str3 + str2;
        AppMethodBeat.o(5641);
        return str4;
    }

    public final long adZ(String str) {
        AppMethodBeat.i(5642);
        String format = String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", at(str, "###@@@@TOTAL@@@###SIZE####", "_")});
        ab.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(format)));
        long j = 0;
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        ab.d("MicroMsg.WebViewDataStorage", "getAppIdSize: ".concat(String.valueOf(j)));
        AppMethodBeat.o(5642);
        return j;
    }

    static String gY(String str, String str2) {
        AppMethodBeat.i(5643);
        String str3 = str + "_" + str2;
        AppMethodBeat.o(5643);
        return str3;
    }
}
