package com.tencent.mm.plugin.remittance.b;

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
    public static final String[] fnj = new String[]{j.a(c.ccO, "RemittanceRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    public static Map<String, c> gms = new HashMap();
    private e bSd;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        AppMethodBeat.i(44710);
        cVar = (c) cVar;
        if (cVar != null && gms.containsKey(cVar.field_transferId)) {
            gms.remove(cVar.field_transferId);
        }
        boolean a = super.a(cVar, strArr);
        AppMethodBeat.o(44710);
        return a;
    }

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(44711);
        cVar = (c) cVar;
        if (cVar != null && gms.containsKey(cVar.field_transferId)) {
            gms.put(cVar.field_transferId, cVar);
        }
        boolean b = super.b(cVar);
        AppMethodBeat.o(44711);
        return b;
    }

    static {
        AppMethodBeat.i(44712);
        AppMethodBeat.o(44712);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "RemittanceRecord", null);
        this.bSd = eVar;
    }

    public final c VN(String str) {
        AppMethodBeat.i(44707);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(44707);
            return null;
        }
        Cursor a = this.bSd.a("RemittanceRecord", gmr, "transferId=?", new String[]{str}, null, null, null, 2);
        try {
            if (a.moveToFirst()) {
                c cVar = new c();
                cVar.d(a);
                a.close();
                AppMethodBeat.o(44707);
                return cVar;
            }
            a.close();
            AppMethodBeat.o(44707);
            return null;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", e, "getRecordByTransferId error: %s", e.getMessage());
            a.close();
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(44707);
        }
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(44708);
        if (cVar != null && gms.containsKey(cVar.field_transferId)) {
            gms.put(cVar.field_transferId, cVar);
        }
        boolean a = super.a(cVar);
        AppMethodBeat.o(44708);
        return a;
    }
}
