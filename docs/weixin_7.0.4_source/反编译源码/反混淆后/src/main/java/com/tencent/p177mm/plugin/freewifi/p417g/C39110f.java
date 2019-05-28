package com.tencent.p177mm.plugin.freewifi.p417g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedHashMap;

/* renamed from: com.tencent.mm.plugin.freewifi.g.f */
public final class C39110f extends C7563j<C34188e> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34188e.ccO, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> mxM = new C119621();

    /* renamed from: com.tencent.mm.plugin.freewifi.g.f$1 */
    static class C119621 extends LinkedHashMap<String, Class> {
        C119621() {
            AppMethodBeat.m2504i(20886);
            put("id", String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
            AppMethodBeat.m2505o(20886);
        }
    }

    static {
        AppMethodBeat.m2504i(20888);
        AppMethodBeat.m2505o(20888);
    }

    public C39110f(C4927e c4927e) {
        super(c4927e, C34188e.ccO, "FreeWifiLog", null);
    }

    /* renamed from: a */
    public final boolean mo62012a(String str, int i, String str2, long j) {
        AppMethodBeat.m2504i(20887);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", str, Integer.valueOf(i), str2, Long.valueOf(j));
        if (C34189m.isEmpty(str)) {
            AppMethodBeat.m2505o(20887);
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            C34188e c34188e = new C34188e();
            c34188e.field_id = str;
            c34188e.field_protocolNumber = i;
            c34188e.field_logContent = str2;
            c34188e.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = mo10101b((C4925c) c34188e);
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret".concat(String.valueOf(b)));
                return b;
            }
            b = mo10103c(c34188e, new String[0]);
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret".concat(String.valueOf(b)));
            rawQuery.close();
            AppMethodBeat.m2505o(20887);
            return b;
        } catch (Exception e) {
            b = e;
            b = C34189m.m56078h(b);
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(20887);
        }
    }
}
