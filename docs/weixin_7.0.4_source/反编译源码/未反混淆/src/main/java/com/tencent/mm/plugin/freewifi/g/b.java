package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )"};
    public static Map<String, String> mxL = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(20878);
        AppMethodBeat.o(20878);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "FreeWifiConfig", null);
    }

    public final String bzw() {
        String message;
        AppMethodBeat.i(20874);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key\tvalue\tmodifyTime\r\n");
        Cursor rawQuery = rawQuery("select key, value, modifyTime from FreeWifiConfig", new String[0]);
        while (rawQuery.moveToNext()) {
            try {
                stringBuilder.append(rawQuery.getString(0)).append("\t").append(rawQuery.getString(1)).append("\t").append(rawQuery.getLong(2)).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            } catch (Exception e) {
                ab.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + e.getMessage());
                message = e.getMessage();
            } finally {
                rawQuery.close();
                AppMethodBeat.o(20874);
            }
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiConfigStorage", "FreeWifiConfig Table :\r\n" + stringBuilder.toString());
        message = stringBuilder.toString();
        return message;
    }

    public final String MJ(String str) {
        AppMethodBeat.i(20875);
        String str2;
        if (m.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(20875);
            return str2;
        }
        try {
            if (mxL != null) {
                str2 = (String) mxL.get(str);
                if (str2 != null) {
                    AppMethodBeat.o(20875);
                    return str2;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map get error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        if (rawQuery == null) {
            str2 = "";
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(20875);
            return str2;
        }
        try {
            if (rawQuery.moveToFirst()) {
                a aVar = new a();
                aVar.d(rawQuery);
                str2 = aVar.field_value;
                return str2;
            }
            str2 = "";
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(20875);
            return str2;
        } finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(20875);
        }
    }

    public final void et(String str, String str2) {
        AppMethodBeat.i(20876);
        if (m.isEmpty(str) || m.isEmpty(str2)) {
            AppMethodBeat.o(20876);
            return;
        }
        try {
            if (mxL != null) {
                if (mxL.size() < 1000) {
                    mxL.put(str, str2);
                } else {
                    mxL.clear();
                    mxL.put(str, str2);
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map put error!");
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiConfig where key = '" + str + "'", new String[0]);
        try {
            a aVar = new a();
            aVar.field_key = str;
            aVar.field_value = str2;
            aVar.field_modifyTime = System.currentTimeMillis();
            if (rawQuery.getCount() == 0) {
                b((c) aVar);
            } else {
                c(aVar, new String[0]);
            }
            rawQuery.close();
            AppMethodBeat.o(20876);
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(20876);
        }
    }

    public final void axQ() {
        AppMethodBeat.i(20877);
        if (mxL != null) {
            mxL.clear();
        }
        super.hY("FreeWifiConfig", "delete from FreeWifiConfig");
        AppMethodBeat.o(20877);
    }
}
