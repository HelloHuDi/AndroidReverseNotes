package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "AAPayRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private e bSd;

    static {
        AppMethodBeat.i(40665);
        AppMethodBeat.o(40665);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "AAPayRecord", null);
        this.bSd = eVar;
    }

    public final a vG(String str) {
        AppMethodBeat.i(40664);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(40664);
            return null;
        }
        Cursor a = this.bSd.a("AAPayRecord", gmr, "payMsgId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                a aVar = new a();
                aVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(40664);
                return aVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(40664);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.AAPayRecordStorage", "getByPayMsgId error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(40664);
        }
    }
}
