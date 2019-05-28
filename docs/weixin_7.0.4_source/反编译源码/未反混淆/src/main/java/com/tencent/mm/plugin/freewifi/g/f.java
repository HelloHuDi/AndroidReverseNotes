package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;

public final class f extends j<e> {
    public static final String[] fnj = new String[]{j.a(e.ccO, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> mxM = new LinkedHashMap<String, Class>() {
        {
            AppMethodBeat.i(20886);
            put("id", String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
            AppMethodBeat.o(20886);
        }
    };

    static {
        AppMethodBeat.i(20888);
        AppMethodBeat.o(20888);
    }

    public f(e eVar) {
        super(eVar, e.ccO, "FreeWifiLog", null);
    }

    public final boolean a(String str, int i, String str2, long j) {
        AppMethodBeat.i(20887);
        ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", str, Integer.valueOf(i), str2, Long.valueOf(j));
        if (m.isEmpty(str)) {
            AppMethodBeat.o(20887);
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            e eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b((c) eVar);
                ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret".concat(String.valueOf(b)));
                return b;
            }
            b = c(eVar, new String[0]);
            ab.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret".concat(String.valueOf(b)));
            rawQuery.close();
            AppMethodBeat.o(20887);
            return b;
        } catch (Exception e) {
            b = e;
            b = m.h(b);
            ab.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(20887);
        }
    }
}
