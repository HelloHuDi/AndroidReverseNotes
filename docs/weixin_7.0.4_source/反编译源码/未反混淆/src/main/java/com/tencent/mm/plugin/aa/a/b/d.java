package com.tencent.mm.plugin.aa.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "AARecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    public static Map<String, c> gms = new HashMap();
    private e bSd;

    static {
        AppMethodBeat.i(40674);
        AppMethodBeat.o(40674);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "AARecord", null);
        this.bSd = eVar;
    }

    public final c vH(String str) {
        AppMethodBeat.i(40667);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(40667);
            return null;
        }
        Cursor a = this.bSd.a("AARecord", gmr, "billNo=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                c cVar = new c();
                cVar.d(a);
                if (a != null) {
                    a.close();
                }
                AppMethodBeat.o(40667);
                return cVar;
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(40667);
            return null;
        } catch (Exception e) {
            ab.e("MicroMsg.AARecordStorage", "getRecordByBillno error: %s", e.getMessage());
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(40667);
        }
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(40668);
        if (cVar != null && gms.containsKey(cVar.field_billNo)) {
            gms.put(cVar.field_billNo, cVar);
        }
        boolean b = super.b((c) cVar);
        AppMethodBeat.o(40668);
        return b;
    }

    public final boolean a(c cVar, String... strArr) {
        AppMethodBeat.i(40669);
        if (cVar != null && gms.containsKey(cVar.field_billNo)) {
            gms.remove(cVar.field_billNo);
        }
        boolean a = super.a((c) cVar, strArr);
        AppMethodBeat.o(40669);
        return a;
    }

    public final boolean b(c cVar) {
        AppMethodBeat.i(40670);
        if (cVar != null && gms.containsKey(cVar.field_billNo)) {
            gms.put(cVar.field_billNo, cVar);
        }
        boolean a = super.a(cVar);
        AppMethodBeat.o(40670);
        return a;
    }
}
